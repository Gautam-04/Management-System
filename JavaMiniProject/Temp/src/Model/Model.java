package Model;

public class Model
{
    protected manageListener manageListenerData = new manageListener();

    public Model()
    {
        manageListenerData.setLinesBeingDisplayed(14);
        manageListenerData.setFirstLineToDisplay(1);
    }

    public manageListener getManageListenerData()
    {
        return manageListenerData;
    }
}
