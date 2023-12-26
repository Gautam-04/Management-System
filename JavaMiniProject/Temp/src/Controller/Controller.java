package Controller;

import Model.Model;
import View.View;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class Controller {
    Model model;
    View view;

    public Controller(Model m, View v) {
        model = m;
        view = v;
        view.centerInitialSetup(model.getManageListenerData().getLinesBeingDisplayed(), model.getManageListenerData().getHeaders().size());
        view.centerUpdate(model.getManageListenerData().getLines(model.getManageListenerData().getFirstLineToDisplay(), model.getManageListenerData().getLastLineToDisplay()), model.getManageListenerData().getHeaders());
        addScrolling();
    }

    private void addScrolling()
    {
        view.getMf().getIp().getCp().addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int units = e.getUnitsToScroll();
                System.out.println(units);
                int current_first_line = model.getManageListenerData().getFirstLineToDisplay();
                int current_last_line = model.getManageListenerData().getLastLineToDisplay();
                int no_of_players = model.getManageListenerData().getTable().size();
                int no_of_display_lines = model.getManageListenerData().getLinesBeingDisplayed();
                if(units <= 0 && current_first_line == 0)
                {
                    model.getManageListenerData().setFirstLineToDisplay(0);
                }
                else if(units <= 0 && current_first_line > 0)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line <= 0)
                    {
                        model.getManageListenerData().setFirstLineToDisplay(0);
                    }
                    else
                    {
                        model.getManageListenerData().setFirstLineToDisplay(new_first_line);
                    }
                }
                else if(units > 0 && current_last_line == no_of_players-1)
                {
                    model.getManageListenerData().setFirstLineToDisplay(current_first_line);
                }
                else if (units > 0 && current_last_line < no_of_players-1)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line > no_of_players - no_of_display_lines)
                    {
                        new_first_line = no_of_players-no_of_display_lines;
                        model.getManageListenerData().setFirstLineToDisplay(new_first_line);
                    }
                    else
                    {
                        model.getManageListenerData().setFirstLineToDisplay(new_first_line);
                    }
                }

                view.centerUpdate(model.getManageListenerData().getLines(model.getManageListenerData().getFirstLineToDisplay(), model.getManageListenerData().getLastLineToDisplay()), model.getManageListenerData().getHeaders());
            }
        });
    }
}
