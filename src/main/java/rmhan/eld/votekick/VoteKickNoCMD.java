package rmhan.eld.votekick;

import com.ericlam.mc.eld.annotations.Commander;
import com.ericlam.mc.eld.bukkit.CommandNode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.inject.Inject;

@Commander(
        name = "no",
        description = "投下否決票",
        playerOnly = true
)

public class VoteKickNoCMD implements CommandNode {
    @Inject
    private KickManager status;
    @Override
    public void execute(CommandSender sender) {
        if (status.getStatus()){
            if (status.AddNo((Player)sender)){
                sender.sendMessage("已成功投票，目前比數 贊成：失敗為"  + status.getYesNums() + ":" + status.getNoNums());
            }else{
                sender.sendMessage("你已經投過票了!");
            }
        }else{
            sender.sendMessage("尚未有投票被發起。");
        }
    }
}
