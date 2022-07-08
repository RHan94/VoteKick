package rmhan.eld.votekick;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class KickInfo{
    private static KickInfo instance;

    private Player sponsor;
    private Player Target;
    private String Reason;
    private static Boolean Status = false; //false: 尚未有投票被發起
    private List Players = new ArrayList();

    private int Yes = 0;
    private int No = 0;

    public void setInstance(Player s,Player t,String r) {
        sponsor = s;
        Target = t;
        Reason = r;
        Players.clear();
        Status = true;
    }

    public boolean getStatus(){
        return Status;
    }
    public void EndVote(){
        Status = false;
    }
    public String getInfo(){
        if (Status == true) {
            return "發起人: " + sponsor.getName() + "\n對象: " + Target.getName() + "\n原因:" + Reason;
        }else{
            return "尚未有投票被發起";
        }
    }
    public String getYesNums(){
        return Integer.toString(Yes);
    }
    public String getNoNums(){
        return Integer.toString(No);
    }
    public boolean AddYes(Player p){
        if (Players.indexOf(p) != -1){
            return false;
        }
        Players.add(p);
        Yes++;
        return true;
    }
    public boolean AddNo(Player p){
        if (Players.indexOf(p) != -1){
            return false;
        }
        Players.add(p);
        No++;
        return true;
    }
}
