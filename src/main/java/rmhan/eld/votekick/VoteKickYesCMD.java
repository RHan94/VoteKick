package rmhan.eld.votekick;

import com.ericlam.mc.eld.annotations.Commander;
import com.ericlam.mc.eld.bukkit.CommandNode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.inject.Inject;
@Commander(
        name = "yes",
        description = "投下贊成票"
)

public class VoteKickYesCMD implements CommandNode {
    @Inject
    private KickInfo status;
    @Override
    public void execute(CommandSender sender) {
        if (status.getStatus()){
            if (status.AddYes((Player)sender)){
                sender.sendMessage("已成功投票，目前比數 贊成：失敗為"  + status.getYesNums() + ":" + status.getNoNums());
            }else{
                sender.sendMessage("你已經投過票了!");
            }
        }else{
            sender.sendMessage("尚未有投票被發起。");
        }
    }
}
