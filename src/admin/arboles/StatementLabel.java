package admin.arboles;
import org.eclipse.swt.widgets.Label;

import java.util.ArrayList;

import org.eclipse.jdt.core.dom.Statement;
public class StatementLabel {
	Label labelactual;
	Statement statement;
	ArrayList<StatementLabel> listaStatements;
	public void StatementLabel(Statement estado) {
		this.statement = estado;
		this.labelactual = 
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
