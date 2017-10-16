package admin.arboles;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.EnhancedForStatement;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.ForStatement;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.WhileStatement;

import view.Comandos;
import view.EView;
import view.Labels;
import view.ViewFactory;
public class StatementLabel {
	public static int x = 0;
	static int y = 0;
	Labels labelsactual;
	Statement statement;
	ArrayList<StatementLabel> listaStatements;
	public StatementLabel(Statement estado) {
		if (estado == null) {
		this.statement = estado;
		this.labelsactual = null;
		this.listaStatements = new ArrayList<>();}
	
	else {		this.statement = estado;

	this.labelsactual = ViewFactory.getGrafic(EView.clas, Labels.toComando(estado),EView.canvas, estado.toString());
	this.listaStatements = new ArrayList<>();}
		
//	this.labelsactual.setPos(x, y);
//	x+=100;  .getExpression()
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
}
