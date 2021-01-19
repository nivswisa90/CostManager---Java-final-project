package costManager;

import costManager.model.DerbyDBModel;
import costManager.model.IModel;
import costManager.view.IView;
import costManager.view.View;
import costManager.viewmodel.IViewModel;
import costManager.viewmodel.ViewModel;

public class Application {
    public static void main(String args[]) {

        IModel model = new DerbyDBModel();
        IView view = new View();
        IViewModel vm = new ViewModel();

        //connecting components together

        view.setViewModel(vm);
        vm.setModel(model);
        vm.setView(view);
    }
}
