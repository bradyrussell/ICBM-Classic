package icbm.classic.prefab.item;

import icbm.classic.lib.LanguageUtility;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

import java.util.List;

/**
 * Generic prefab to use in all items providing common implementation
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 12/20/2016.
 */
public abstract class ItemAbstract extends Item
{
    //Make sure to mirror all changes to other abstract class
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, World world, List<String> list, ITooltipFlag flag)
    {
        EntityPlayer player = Minecraft.getMinecraft().player;

        //Generic info, shared by item group
        splitAdd(getUnlocalizedName() + ".info", list, false);

        if (hasDetailedInfo(stack, player))
        {
            getDetailedInfo(stack, player, list);
        }

        if (hasShiftInfo(stack, player))
        {
            if (!Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
            {
                list.add(LanguageUtility.getLocal("info.voltzengine:tooltip.noShift").replace("#0", "\u00a7b").replace("#1", "\u00a77"));
            }
            else
            {
                getShiftDetailedInfo(stack, player, list);
            }
        }
    }

    /**
     * Gets the detailed information for the item shown after the
     * global generic item details.
     *
     * @param stack
     * @param player
     * @param list
     */
    protected void getDetailedInfo(ItemStack stack, EntityPlayer player, List<String> list)
    {
        //Per item detailed info
        splitAdd(getUnlocalizedName(stack) + ".info", list, true);
    }

    /**
     * Gets the detailed when shift is held information for the item shown after the
     * global generic item details.
     * <p>
     * This is in addition to normal details
     *
     * @param stack
     * @param player
     * @param list
     */
    protected void getShiftDetailedInfo(ItemStack stack, EntityPlayer player, List<String> list)
    {
        //Per item detailed info
        splitAdd(getUnlocalizedName(stack) + ".info.detailed", list, true);
    }

    protected void splitAdd(String translationKey, List<String> list, boolean addKeyIfEmpty)
    {
        String translation = LanguageUtility.getLocal(translationKey);
        if (!translation.isEmpty() && !translation.equals(translationKey))
        {
            if (translation.contains(","))
            {
                String[] split = translation.split(",");
                for (String s : split)
                {
                    list.add(s.trim());
                }
            }
            else if (addKeyIfEmpty)
            {
                list.add(translation);
            }
        }
    }

    /**
     * Does the item have detailed information to be shown
     *
     * @param stack
     * @param player
     * @return
     */
    protected boolean hasDetailedInfo(ItemStack stack, EntityPlayer player)
    {
        return false;
    }

    /**
     * Does the item have detailed information to be shown when
     * shift is held
     *
     * @param stack
     * @param player
     * @return
     */
    protected boolean hasShiftInfo(ItemStack stack, EntityPlayer player)
    {
        return false;
    }
}