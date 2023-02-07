package find_pc.view.cli;

import find_pc.app_controller.FindPCController;
import find_pc.model.Result;

import java.util.ArrayList;

public class CLIResultList {
    public CLIResultList(FindPCController controller, ArrayList<Result> results) {
        this.controller = controller;
        this.results=results;
    }
    FindPCController controller;
    ArrayList<Result> results;
    public void execute(){

    }
}