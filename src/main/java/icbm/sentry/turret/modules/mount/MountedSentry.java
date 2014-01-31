package icbm.sentry.turret.modules.mount;

import icbm.sentry.turret.Sentry;
import icbm.sentry.turret.SentryTypes;
import icbm.sentry.turret.block.TileSentry;
import universalelectricity.api.vector.Vector3;

/** this sentry uses for mounting the player in position */
public class MountedSentry extends Sentry
{
    protected Vector3 riderOffset = new Vector3(0.5, 1.2, 0.5);

    public MountedSentry(TileSentry host)
    {
        super(host);
    }

    public Vector3 getRiderOffset()
    {
        return this.riderOffset;
    }

    @Override
    public SentryTypes getSentryType ()
    {
        return SentryTypes.CLASSIC;
    }

}