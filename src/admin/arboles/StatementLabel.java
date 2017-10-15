package admin.arboles;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

import java.util.ArrayList;
import org.eclipse.swt.SWT;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.Block;

import org.eclipse.jdt.core.dom.EnhancedForStatement;
import org.eclipse.jdt.core.dom.ExpressionStatement;
import org.eclipse.jdt.core.dom.ForStatement;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.WhileStatement;
import com.sun.javafx.scene.web.Debugger;

import view.Labels;
public class StatementLabel {
	Labels labelactual;
	Statement statement;
	ArrayList<StatementLabel> listaStatements;
	public StatementLabel(Statement estado) {
		this.statement = estado;
		this.labelactual = null;
		this.listaStatements = new ArrayList<>();
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
