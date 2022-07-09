package rmhan.eld.votekick;

import com.ericlam.mc.eld.annotations.Resource;
import com.ericlam.mc.eld.components.Configuration;

@Resource(locate = "config.yml")
public class KickConfig extends Configuration {
    public boolean Enable;
    public int VoteMins;
}
