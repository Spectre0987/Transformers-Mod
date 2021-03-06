package com.marctron.transformersmod.transformers.transformer.wfc.stunticons.breakdown.transformation;

import java.util.List;

import javax.annotation.Nullable;

import com.marctron.transformersmod.Main;
import com.marctron.transformersmod.transformers.transformer.ArmorTypes;
import com.marctron.transformersmod.transformers.transformer.ItemArmorTransformer;
import com.marctron.transformersmod.transformers.transformer.wfc.stunticons.breakdown.BreakdownArmorTypes;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WFCBreakdownMid2 extends ItemArmorTransformer{

	
	public WFCBreakdownMid2(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(null);
		setMaxStackSize(1);
		
	}
	
	
	public void addInformation(ItemStack stack, @Nullable World world, List<String> list, ITooltipFlag flag) {
		list.add(TextFormatting.GRAY + I18n.format(TextFormatting.BOLD + I18n.format("WFC")));
	}
	
	@Override
	public final void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
			if(player.onGround){
					player.motionX=player.motionX * 1.06F;
					player.motionZ=player.motionZ * 1.06F;
					Altmode(false);
				
		}
			if (world.isRemote)
			{}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public final ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {
	
		if(!itemStack.isEmpty())
		{
			
			
			if(itemStack.getItem() instanceof ItemArmor) 
				{
					
					
					
				
					
			
				BreakdownArmorTypes.modelBreakdownMid2.bipedHead.showModel = armorSlot == EntityEquipmentSlot.HEAD;
				BreakdownArmorTypes.modelBreakdownMid2.bipedHeadwear.showModel = armorSlot == EntityEquipmentSlot.HEAD;
				BreakdownArmorTypes.modelBreakdownMid2.bipedBody.showModel = (armorSlot == EntityEquipmentSlot.CHEST) || (armorSlot == EntityEquipmentSlot.CHEST);
				BreakdownArmorTypes.modelBreakdownMid2.bipedRightArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
				BreakdownArmorTypes.modelBreakdownMid2.bipedLeftArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
				BreakdownArmorTypes.modelBreakdownMid2.bipedRightLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS);
				BreakdownArmorTypes.modelBreakdownMid2.bipedLeftLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS);

				BreakdownArmorTypes.modelBreakdownMid2.isSneak = _default.isSneak;
				BreakdownArmorTypes.modelBreakdownMid2.isRiding = _default.isRiding;
				BreakdownArmorTypes.modelBreakdownMid2.isChild = _default.isChild;
				BreakdownArmorTypes.modelBreakdownMid2.rightArmPose = _default.rightArmPose;
				BreakdownArmorTypes.modelBreakdownMid2.leftArmPose = _default.leftArmPose;

					return BreakdownArmorTypes.modelBreakdownMid2;
				}
			}
			
			return null;
		}

}
