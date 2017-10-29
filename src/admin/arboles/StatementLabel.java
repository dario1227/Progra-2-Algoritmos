package admin.arboles;
import java.util.ArrayList;

import java.util.List;
import org.eclipse.swt.widgets.Label;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.EnhancedForStatement;
import org.eclipse.jdt.core.dom.ForStatement;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.WhileStatement;
import view.EView;
import view.Labels;
import view.ViewFactory;
/**
 * Clase que contiene el grafo y todo lo necesario para graficar metodos
 * @author kenne
 *
 */
public class StatementLabel {
	public static int x = 0;
	static int y = 0;
	public Labels labelsactual;
	public Statement statement;
	ArrayList<Label> lineas;
	public ArrayList<StatementLabel> listaStatements;
	public ArrayList<StatementLabel> listaElse;
	public StatementLabel(Statement estado) {
		if (estado == null) {
		this.statement = estado;
		this.labelsactual = null;
		this.listaStatements = new ArrayList<>();
		this.lineas = new ArrayList<>();
		if(this.statement !=null) {
			
		}
		}
		else if(estado instanceof IfStatement ) {

			this.statement = estado;
			this.labelsactual = ViewFactory.getGrafic(EView.clas, Labels.toComando(estado),EView.canvas, expresion(estado));;
			this.listaStatements = new ArrayList<>();
			this.lineas = new ArrayList<>();

			if(this.statement !=null) {
				
			}
			try {
			this.listaElse = DecomposeIf(((IfStatement) estado).getElseStatement());}catch(Exception e) {
				
				this.listaElse = null;
			}
		}
	else {	
	this.statement = estado;
	this.lineas = new ArrayList<>();
	this.labelsactual = ViewFactory.getGrafic(EView.clas, Labels.toComando(estado),EView.canvas, expresion(estado));
	this.listaStatements = new ArrayList<>();
	if(this.statement !=null) {
	}}
		
//	this.labelsactual.setPos(x, y);
//	x+=100;  .getExpression()
	}
	/**
	 * Descompone el else del if para tenerlo en la lista como el listaElse
	 * @param elseStatement
	 * @return
	 */
	private ArrayList<StatementLabel> DecomposeIf(Statement elseStatement) {
		if(elseStatement ==null) {
			System.out.println("ENTRE PERO NO HABIA UN ELSE MAE QUE PEREZA");
			return null;
		}
		else {//lol
			
			System.out.println("ENTRE PERO SIIIIIIIIIIIIII HABIA UN ELSE MAE QUE PEREZA");
			List<StatementLabel> lista =new ArrayList<>();
	List<Statement>  estados = ((Block) elseStatement).statements();
	for(Statement estado:estados) {
		lista.add(new StatementLabel(estado));
	}
	return (ArrayList<StatementLabel>) lista;
		}
	}
	/**
	 * Es el metodo principal que va a entrar en el statementLabel de busqueda
	 * @param statement es el statement que se supone va a dar el debugger
	 * @return
	 */
	public StatementLabel buscaStatementLabel(Statement statement) {
		StatementLabel label = null;
		for(StatementLabel state : this.listaStatements) {
			if(state.statement.equals(statement)) {
				label = state;
				return label;
			}
			if (label != null) {
				break;
			}
			if(!state.listaStatements.isEmpty()) {
				label = buscaStatementLabelaux(statement,state);
			}
		}
		return label;
	}
	/**
	 * Codigo auxiliar para entrar en los grafos mas profundos, recibe un statements y un 
	 * statementlabel,de este ultimp optiene la lista de StatementLabels y va comprobando una por una
	 * si es el objeto requerido lo retorna, el StatementLabel que lo contiene
	 * @param statement
	 * @param state
	 * @return
	 */
	private StatementLabel buscaStatementLabelaux(Statement statement, StatementLabel state) {
		StatementLabel label = null;
		for(StatementLabel actual : state.listaStatements) {
			if(actual.statement.equals(statement)) {
				label = actual;
			}
			if (label != null) {
				break;
			}
			if(!actual.listaStatements.isEmpty()) {
				label = buscaStatementLabelaux(statement,actual);
			}
		}
		return label;
	}
	private static void cambiaLabel(StatementLabel state) {
		//Aqui meta las varas de como cambiar el color a un label o asi, ya que esto lo que puede optener es el label
	}
	private static  String expresion(Statement estado) {
		if(estado instanceof IfStatement ) {
			return "if  "+ ((IfStatement) estado).getExpression().toString();}
		else if(estado instanceof WhileStatement) {
			return "while  " +((WhileStatement) estado).getExpression().toString();
		}
		else if(estado instanceof ForStatement) {
			return "For  "+ ((ForStatement) estado).getExpression().toString();
			
		}
		else if(estado instanceof EnhancedForStatement) {
			return "For  " + ((EnhancedForStatement) estado).getExpression().toString();
		}
		else  {
			return estado.toString();
		}
	}
	public  int getProfundidad() {
		return getprofundidadAux(this.listaStatements,0);
	}
	/**
	 * Metodo sacado de la manga quien sabe como lo saque que calcula el grado de profundidad de un grafo
	 * @param listaStatements2
	 * @param x
	 * @return
	 */
	private int getprofundidadAux(ArrayList<StatementLabel> listaStatements2, int x) {
		if(listaStatements2.isEmpty()) {
			return x;
		}
		 x++;
		int prof = 0;
		List<Integer> lista = new ArrayList<>();
		for(StatementLabel labelA :listaStatements2 ) {
			int y = getprofundidadAux(labelA.listaStatements,x);
			lista.add(y);
		}
		return SacaMax(lista);
	}
	private int SacaMax(List<Integer> lista) {
		int x = 0;
		for(int i:lista) {
			if(i>x) {
				x=i;
			}
		}
		return x;
	}
	public boolean buscaStatementString(String string) {
		
		for(StatementLabel state : this.listaStatements) {
			if(this.sacaString().equals(string)) {
				
				return true;
			}
			
			if(!state.listaStatements.isEmpty()) {
				return buscaStatementStringAux(string,state);
			}
		}
		return false;
	}
	private boolean buscaStatementStringAux(String statement, StatementLabel state) {
		
		for(StatementLabel buscado : this.listaStatements) {
			if(buscado.sacaString().equals(statement)) {
				
				return true;
			}
			
			if(!state.listaStatements.isEmpty()) {
				return buscaStatementStringAux(statement,state);
			}
		}
		return false;
	}
	private String sacaString() {
		String retornable = "";
		String desarrollable = this.statement.toString();
		int x = 0;
		while(x<desarrollable.length()) {
			String cosa = "";
			cosa ="" + desarrollable.charAt(x);
			if( cosa.equals("{")|| cosa.equals(";")) {
				if( cosa.equals("{")) {
					return retornable + "{";
				}
				else {
					return retornable + ";";
				}
				
			}
			else {
				retornable = retornable + desarrollable.charAt(x);
			}
		}
		return retornable;
	}
	public void hidePictures(ArrayList<StatementLabel> listaStatements2) {
try {
		this.labelsactual.hide();
}catch(Exception e) {}
		for(Label label:this.lineas) {
			label.setVisible(false);
		}
	}
}
