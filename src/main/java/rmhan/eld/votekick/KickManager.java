package rmhan.eld.votekick;

import org.bukkit.entity.Player;

import javax.inject.Inject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class KickManager {
    private final KickConfig config;
    @Inject
    public KickManager(KickConfig config){
        this.config = config;
        this.Enable = config.Enable;
    }
    private Player Sponsor;
    private Player Target;
    private String Reason;
    private boolean Enable;
    private  Boolean Status = false; //false: 尚未有投票被發起
    private List<Player> Players = new ArrayList();

    private int Yes = 0;
    private int No = 0;

    public void setInstance(Player s,Player t,String r) {
        Sponsor = s;
        Target = t;
        Reason = r;
        Players.clear();
        Yes = 0;
        No = 0;
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
            return "發起人: " + Sponsor.getName() + "\n對象: " + Target.getName() + "\n原因:" + Reason;
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
    public void ToggleEnable(){
        Enable = !Enable;
        config.Enable = Enable;
        try {
            config.getController().save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public boolean getEnable(){
        return Enable;
    }
}
