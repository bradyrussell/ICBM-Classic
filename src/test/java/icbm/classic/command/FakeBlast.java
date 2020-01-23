package icbm.classic.command;

import icbm.classic.api.explosion.BlastState;
import icbm.classic.api.explosion.IBlast;
import icbm.classic.api.explosion.IBlastInit;
import icbm.classic.api.reg.IExplosiveData;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Created by Robert Seifert on 1/6/20.
 */
public class FakeBlast implements IBlastInit
{
    public World world;
    public Entity source;
    public double x;
    public double y;
    public double z;
    public double size = 1;

    public NBTTagCompound customData;

    public IExplosiveData data;

    public boolean triggered = false;
    public boolean isAlive = true;

    private final BlastState returnState;

    public FakeBlast(BlastState returnState)
    {
        this.returnState = returnState;
    }

    @Override
    public IBlastInit setBlastSize(double size)
    {
        this.size = size;
        return this;
    }

    @Override
    public IBlast scaleBlast(double scale)
    {
        return setBlastSize(scale * getBlastRadius());
    }

    @Override
    public IBlastInit setBlastSource(Entity entity)
    {
        this.source = source;
        return this;
    }

    @Override
    public IBlastInit setBlastWorld(World world)
    {
        this.world = world;
        return this;
    }

    @Override
    public IBlastInit setBlastPosition(double x, double y, double z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        return this;
    }

    @Override
    public IBlastInit setCustomData(@Nonnull NBTTagCompound customData)
    {
        this.customData = customData;
        return this;
    }

    @Override
    public IBlastInit setEntityController(Entity entityController)
    {
        return this;
    }

    @Override
    public IBlastInit setExplosiveData(IExplosiveData data)
    {
        this.data = data;
        return this;
    }

    @Override
    public IBlastInit buildBlast()
    {
        return this;
    }

    @Override
    public float getBlastRadius()
    {
        return (float) size;
    }

    @Override
    public Entity getBlastSource()
    {
        return this.source;
    }

    @Override
    public BlastState runBlast()
    {
        triggered = true;
        return returnState;
    }

    @Override
    public boolean isCompleted()
    {
        return triggered;
    }

    @Nullable
    @Override
    public IExplosiveData getExplosiveData()
    {
        return this.data;
    }

    @Nullable
    @Override
    public Entity getController()
    {
        return null;
    }

    @Override
    public void clearBlast()
    {
        isAlive = false;
    }

    @Override
    public World world()
    {
        return this.world;
    }

    @Override
    public double z()
    {
        return z;
    }

    @Override
    public double x()
    {
        return x;
    }

    @Override
    public double y()
    {
        return y;
    }
}
