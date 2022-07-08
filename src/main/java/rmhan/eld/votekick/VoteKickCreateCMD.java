package rmhan.eld.votekick;

import com.ericlam.mc.eld.annotations.CommandArg;
import com.ericlam.mc.eld.annotations.Commander;
import com.ericlam.mc.eld.bukkit.CommandNode;
import com.ericlam.mc.eld.services.ScheduleService;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;

import javax.inject.Inject;

@Commander(
        name="create",
        description = "向伺服器發起是否踢除某人的表決"
)
public class VoteKickCreateCMD implements CommandNode {
    @CommandArg(order = 0)
    private Player player;
    @CommandArg(order = 1)
    private String reason;
    @Inject
    private KickInfo status;
    @Inject
    private ScheduleService service;
    @Override
    public void execute(CommandSender sender) {
        if (!status.getStatus()){
            status.setInstance((Player)sender,player,reason);
            Bukkit.broadcastMessage("請投票:\n" + status.getInfo());
            Bukkit.broadcastMessage("輸入 /vk yes 或 /vk no來投票");
            status.AddYes((Player) sender);
            service.injectTask(new BukkitRunnable() {
                @Override
                public void run() {
                    if (Integer.parseInt(status.getYesNums()) > Integer.parseInt(status.getNoNums())){
                        Bukkit.broadcastMessage("投票結束，比數為" + status.getYesNums() + ":" + Integer.parseInt(status.getNoNums()));
                        player.kick();
                        Bukkit.broadcastMessage("已將" + player.getName() + "以" + reason + "為由踢除");
                     }else{
                        Bukkit.broadcastMessage("投票結束，比數為" + status.getYesNums() + ":" + Integer.parseInt(status.getNoNums()));
                        Bukkit.broadcastMessage("贊成票數未高於否決票數，不予懲處");
                    }
                    status.EndVote();
                }
            }).asynchronous(false).timeout(200L).run(VoteKick.getProvidingPlugin(VoteKick.class));

        }else{
            sender.sendMessage("請等待目前的投票表決後，再次發起。");
        }

    }
}
