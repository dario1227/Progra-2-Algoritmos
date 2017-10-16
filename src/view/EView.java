package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.part.ViewPart;
/*
 * depende de una de las extensiones del plugin, y esta clase lo "complementa"
 */
public class EView extends ViewPart {
	public static Composite actual;
	public static Class<? extends EView> clas;
	public static Canvas canvas;
	public static ScrolledComposite scroll;
	public EView() {

	}
	
/*
 *
 * Contenido del view
 */
	@Override
	public void createPartControl(Composite parent) {
		scroll= new ScrolledComposite(parent,SWT.H_SCROLL | SWT.V_SCROLL);
		actual = parent;
		System.out.println("MAE ME ESTOY EJECUTANDO :DDDDDDDDDDDDDD");
		//Canvas canvas = new Canvas(parent,SWT.NONE);
		canvas = new Canvas(scroll,SWT.NONE);
		Menu menu= new Menu(canvas);
		MenuItem back=new MenuItem(menu, SWT.PUSH);
		back.setText("Go Back");
		 back.addListener(SWT.Selection, new Listener()
		    {
		        @Override
		        public void handleEvent(Event event)
		        {
		        System.out.println("back");
		        }
		    });
		 canvas.setMenu(menu);
		 scroll.setContent(canvas);
//		//Class<? extends EView> clas = getClass();
		 clas = getClass();
		 scroll.setExpandHorizontal(true);
		 scroll.setExpandVertical(true);
//		ViewFactory.getGrafic(clas, Comandos.For,canvas, "helor nigga");
//		ViewFactory.getGrafic(clas, Comandos.While,canvas, "helor nigga");
//		ViewFactory.getGrafic(clas, Comandos.If,canvas, "helor nigga");
//		ViewFactory.getGrafic(clas, Comandos.Accion,canvas, "helor nigga");

	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
