package UI.controller;

import Noise.*;
import javafx.scene.Node;


public class BaseController implements Controller {

    private Node view;

    @Override
    public Node getView() {
        return view;
    }

    @Override
    public void setView (Node view){
        this.view = view;
    }

    @Override
    public void Show() {
        PreShowing();
        Noise.getNavigation().Show(this);
        PostShowing();
    }

    public void PreShowing()
    {
    }

    public void PostShowing()
    {
    }
}