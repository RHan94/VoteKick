package rmhan.eld.votekick.Logs;

import com.ericlam.mc.eld.annotations.GroupResource;
import com.ericlam.mc.eld.components.GroupConfiguration;
import org.bukkit.entity.Player;

@GroupResource(folder="Logs")
public class VoteLog extends GroupConfiguration {
    public String Sponsor;
    public String Target;
    public String Reason;
    public String Result;
}
