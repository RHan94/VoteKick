package rmhan.eld.votekick;

import com.ericlam.mc.eld.annotations.CommandArg;
import com.ericlam.mc.eld.annotations.Commander;
import com.ericlam.mc.eld.bukkit.CommandNode;
import com.ericlam.mc.eld.services.ScheduleService;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import javax.inject.Inject;

@Commander(
        name="create",
        description = "向伺服器發起是否踢除某人的表決"
)
public class VoteKickCreateCMD implements CommandNode {
    @CommandArg(order = 0)
    private Player Target;
    @CommandArg(order = 1)
    private String Reason;
    @Inject
    private KickManager Status;
    @Inject
    private ScheduleService Service;
    @Inject
    private KickConfig config;
    @Override
    public void execute(CommandSender sender) {
        if (Status.getEnable()){
            if (!Status.getStatus()){
                Status.setInstance((Player)sender,Target,Reason);
                Bukkit.broadcastMessage("請投票:\n" + Status.getInfo());
                Bukkit.broadcastMessage("輸入 /vk yes 或 /vk no來投票");
                Status.AddYes((Player) sender);
                Service.injectTask(new BukkitRunnable() {
                    @Override
                    public void run() {
                        if (Integer.parseInt(Status.getYesNums()) > Integer.parseInt(Status.getNoNums())){
                            Bukkit.broadcastMessage("投票結束，比數為" + Status.getYesNums() + ":" + Integer.parseInt(Status.getNoNums()));
                            Target.kickPlayer(Reason);
                            Bukkit.broadcastMessage("已將" + Target.getName() + "以" + Reason + "為由踢除");
                        }else{
                            Bukkit.broadcastMessage("投票結束，比數為" + Status.getYesNums() + ":" + Integer.parseInt(Status.getNoNums()));
                            Bukkit.broadcastMessage("贊成票數未高於否決票數，不予懲處");
                        }
                        Status.EndVote();
                    }
                }).asynchronous(false).timeout(20 * 60 * config.VoteMins).run(VoteKick.getProvidingPlugin(VoteKick.class));

            }else{
                sender.sendMessage("請等待目前的投票表決後，再次發起。");
            }
        }else{
            sender.sendMessage("目前不允許發起投票，請聯繫管理員處理。");
        }
    }
}
