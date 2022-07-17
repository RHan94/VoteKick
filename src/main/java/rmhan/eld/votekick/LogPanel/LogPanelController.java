package rmhan.eld.votekick.LogPanel;

import com.ericlam.mc.eld.annotations.InjectPool;
import com.ericlam.mc.eld.configurations.GroupConfig;
import com.ericlam.mc.eldgui.controller.UIController;
import com.ericlam.mc.eldgui.event.ClickMapping;
import com.ericlam.mc.eldgui.view.BukkitView;
import org.bukkit.entity.Player;
import rmhan.eld.votekick.KickManager;
import rmhan.eld.votekick.Logs.VoteLog;
import rmhan.eld.votekick.VotePanel.PanelView;

import javax.inject.Inject;
import java.util.ArrayList;

@UIController("LogController")
public class LogPanelController {
    @InjectPool
    private GroupConfig<VoteLog> Logs;
    ArrayList<VoteLog> LogsList = (ArrayList<VoteLog>) Logs.findAll();
    @Inject
    private KickManager kickManager;
    private int i = 0;

    public BukkitView<?, ?> index() {
        String info = "發起人: " + LogsList.get(i).Sponsor;
        info += "\n對象: " + LogsList.get(i).Target;
        info += "\n原因: " + LogsList.get(i).Reason;
        info += "\n結果: " + LogsList.get(i).Result;
        return new BukkitView<>(LogPanelView.class, info);
    }

    @ClickMapping(pattern = 'P', view = PanelView.class)
    public void PreviosPage(Player player) {
        if (i>0){
            i--;
        }
    }

    @ClickMapping(pattern = 'N', view = PanelView.class)
    public void NextPage(Player player) {
        if (i<LogsList.size()-1){
            i++;
        }
    }

}
