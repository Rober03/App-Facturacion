
import controller.ClienteController;
import controller.ClienteControllerImpl;
import controller.FacturaController;
import controller.FacturaControllerImpl;
import java.util.ArrayList;
import java.util.List;
import model.ClienteModel;
import model.ClienteModelImpl;
import model.FacturaModel;
import model.FacturaModelImpl;
import view.GlobalView;
import view.cliente.ClienteView;
import view.cliente.ClienteViewImpl;
import view.factura.FacturaView;
import view.factura.FacturaViewImpl;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rober03
 */
public class Main {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		//Model 
		ClienteModel cmodel= new ClienteModelImpl();
		FacturaModel fmodel= new FacturaModelImpl();
		
		//Controller
		ClienteController ccontroller= new ClienteControllerImpl();
		FacturaController fcontroller= new FacturaControllerImpl();
		
		//Views 
		ClienteView cview= new ClienteViewImpl();
		List<ClienteView> cviews= new ArrayList<>();
		
		cviews.add(cview);
		
		FacturaView fview= new FacturaViewImpl();
		List<FacturaView> fviews= new ArrayList<>();
		
		fviews.add(fview);
		
		//Setup
		ccontroller.setup(cviews, cmodel);
		ccontroller.start();
		
		fcontroller.setup(fviews, fmodel);
		fcontroller.start();
		
		GlobalView g= new GlobalView(cview, fview);
		g.display();
	}
	
}
