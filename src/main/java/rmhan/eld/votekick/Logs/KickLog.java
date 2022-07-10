package rmhan.eld.votekick.Logs;

import com.ericlam.mc.eld.annotations.GroupResource;
import com.ericlam.mc.eld.components.GroupConfiguration;
import org.bukkit.entity.Player;

@GroupResource(folder="Logs")
public class KickLog extends GroupConfiguration {
    public Player Sponsor;
    public Player Target;
    public String Reason;
    public String Result;
}
