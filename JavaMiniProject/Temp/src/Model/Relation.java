package Model;
import java.util.Calendar;

public class Relation {
    private Calendar relationDate;
    private Listener listener;
    private Songs song;

    public void addRelation(Listener tempListener, Songs tempSong, Calendar tempRelationDate) {
        listener = tempListener;
        song = tempSong;
        relationDate = tempRelationDate;
    }

//    public void display_investor_investment()
//    {
//        System.out.println("Student : "+this.ObjInvest.getFullName()+" enrolled for Course : "+this.ObjStock.getStockName()+" on "+this.investment_date.getTime());
//    }
}
