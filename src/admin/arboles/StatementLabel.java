package admin.arboles;
import java.util.ArrayList;
import org.eclipse.jdt.core.dom.Statement;
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
	this.labelsactual.setPos(x, y);
	x+=100;
	this.listaStatements = new ArrayList<>();}
	
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
	
}
