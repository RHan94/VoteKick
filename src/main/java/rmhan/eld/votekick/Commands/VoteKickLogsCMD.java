package rmhan.eld.votekick.Commands;

import com.ericlam.mc.eld.annotations.Commander;
import com.ericlam.mc.eld.annotations.InjectPool;
import com.ericlam.mc.eld.bukkit.CommandNode;
import com.ericlam.mc.eld.configurations.GroupConfig;
import org.bukkit.command.CommandSender;
import rmhan.eld.votekick.Logs.VoteLog;

import java.util.ArrayList;
@Commander(name = "logs",description = "顯示歷史投票紀錄")
public class VoteKickLogsCMD implements CommandNode {
    @InjectPool
    private GroupConfig<VoteLog> Logs;

    @Override
    public void execute(CommandSender sender) {
        ArrayList<VoteLog> LogsList = (ArrayList<VoteLog>) Logs.findAll();
        for(int i = 0;i<LogsList.size();i++){
            sender.sendMessage("發起人:" + LogsList.get(i).Sponsor);
            sender.sendMessage("對象:" + LogsList.get(i).Target);
            sender.sendMessage("原因:" + LogsList.get(i).Reason);
            sender.sendMessage("結果:" + LogsList.get(i).Result);
            sender.sendMessage("========================");
        }
    }
}
