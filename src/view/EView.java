package view;

import javax.swing.text.View;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
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
		back.setText("Save");
		 back.addListener(SWT.Selection, new Listener()
		    {
		        @Override
		        public void handleEvent(Event event)
		        {
		        	int x=0;
		    		int y=0;
		        	GC gc = new GC(scroll);
                    Image image = new Image(ViewFactory.displayR,scroll.getHorizontalBar().getMaximum(),scroll.getVerticalBar().getMaximum());
                    while(x<scroll.getHorizontalBar().getMaximum() && y<scroll.getVerticalBar().getMaximum()) {
                    	gc.copyArea(image, x, 0);
                    	System.out.println("222");
                    	x+=400;
                    	y+=400;
                    }
                    ImageLoader loader = new ImageLoader();
                    loader.data = new ImageData[]{image.getImageData()};
                    loader.save("c:/temp/out.png", SWT.IMAGE_PNG);
                    gc.dispose();
                
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
