package icbm.classic.api.caps;


import icbm.classic.api.IWorldPosition;
import icbm.classic.api.explosion.BlastState;
import icbm.classic.api.explosion.ILauncherContainer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;

/**
 * Capability added to entities to define them as missiles
 *
 * @author DarkGuardsman
 */
public interface IMissile extends IWorldPosition
{
    /**
     * Called to trigger the missile's explosion logic
     */
    BlastState doExplosion();

    /**
     * Has the missile exploded
     *
     * @return true if missile has exploded or is in the process of exploding
     */
    boolean hasExploded();

    /**
     * Called to ask the missile to blow up on next tick
     *
     * @param fullExplosion -
     *                      True will trigger a the missile's normal explosion
     *                      False will trigger a TNT explosion
     */
    default void destroyMissile(boolean fullExplosion) //TODO at reason
    {
        if (!hasExploded() && !doExplosion().good)
        {
            dropMissileAsItem();
        }
    }

    /**
     * Drops the specified missile as an item.
     */
    default void dropMissileAsItem()
    {
        ItemStack stack = toStack();
        if (stack != null && !stack.isEmpty() && world() != null)
        {
            world().spawnEntity(new EntityItem(world(), x(), y(), z(), stack));
        }
    }

    ItemStack toStack();

    /**
     * The amount of ticks this missile has been flying for. Returns -1 if the missile is not
     * flying.
     */
    int getTicksInAir();

    /**
     * Gets the launcher this missile is launched from.
     */
    ILauncherContainer getLauncher();

    /**
     * Launches the missile into a specific target.
     *
     * @param target
     */
    void launch(BlockPos target);

    default void launch(BlockPos target, int height)
    {
        launch(target);
    }
}
