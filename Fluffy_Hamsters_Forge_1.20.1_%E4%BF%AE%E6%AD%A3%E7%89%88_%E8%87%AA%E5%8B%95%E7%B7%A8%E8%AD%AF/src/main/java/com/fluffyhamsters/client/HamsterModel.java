package com.fluffyhamsters.client;

import com.fluffyhamsters.HamsterEntity;
import net.minecraft.client.model.AgeableListModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.util.Mth;
import com.google.common.collect.ImmutableList;

public class HamsterModel extends AgeableListModel<HamsterEntity> {
    private final ModelPart body, head, leftLeg, rightLeg, backLeft, backRight;
    public HamsterModel(ModelPart root) {
        super(false, 0, 0, 0, 0, 0);
        body=root.getChild("body"); head=root.getChild("head");
        leftLeg=root.getChild("front_left"); rightLeg=root.getChild("front_right");
        backLeft=root.getChild("back_left"); backRight=root.getChild("back_right");
    }
    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh=new MeshDefinition(); PartDefinition root=mesh.getRoot();
        root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0,0).addBox(-6,-9,-7,12,10,15).texOffs(0,25).addBox(-6.6f,-8.5f,-6.5f,13.2f,10,14, new CubeDeformation(0.35f)), PartPose.offset(0,20,0));
        PartDefinition h=root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0,0).addBox(-5,-7,-5,10,9,9).texOffs(0,25).addBox(-5.7f,-3.5f,-5.2f,3.3f,4,3.2f).addBox(2.4f,-3.5f,-5.2f,3.3f,4,3.2f),PartPose.offset(0,17,-5));
        h.addOrReplaceChild("ear_left",CubeListBuilder.create().texOffs(48,0).addBox(-1.5f,-4,-0.5f,3,4,2),PartPose.offset(3.6f,-6,0));
        h.addOrReplaceChild("ear_right",CubeListBuilder.create().texOffs(48,0).addBox(-1.5f,-4,-0.5f,3,4,2),PartPose.offset(-3.6f,-6,0));
        h.addOrReplaceChild("nose",CubeListBuilder.create().texOffs(56,0).addBox(-1,-1,-1,2,2,1),PartPose.offset(0,-1,-5));
        h.addOrReplaceChild("eye_left",CubeListBuilder.create().texOffs(56,4).addBox(-1,-1,-0.3f,2,2,1),PartPose.offset(3,-3,-5));
        h.addOrReplaceChild("eye_right",CubeListBuilder.create().texOffs(56,4).addBox(-1,-1,-0.3f,2,2,1),PartPose.offset(-3,-3,-5));
        root.addOrReplaceChild("front_left",CubeListBuilder.create().texOffs(48,10).addBox(-1,0,-1,2,3,3),PartPose.offset(4,21,-5));
        root.addOrReplaceChild("front_right",CubeListBuilder.create().texOffs(48,10).addBox(-1,0,-1,2,3,3),PartPose.offset(-4,21,-5));
        root.addOrReplaceChild("back_left",CubeListBuilder.create().texOffs(48,10).addBox(-1,0,-1,2,3,3),PartPose.offset(4,21,5));
        root.addOrReplaceChild("back_right",CubeListBuilder.create().texOffs(48,10).addBox(-1,0,-1,2,3,3),PartPose.offset(-4,21,5));
        return LayerDefinition.create(mesh,64,64);
    }
    @Override protected Iterable<ModelPart> headParts() { return ImmutableList.of(head); }
    @Override protected Iterable<ModelPart> bodyParts() { return ImmutableList.of(body,leftLeg,rightLeg,backLeft,backRight); }
    @Override public void setupAnim(HamsterEntity entity, float limbSwing,float limbSwingAmount,float ageInTicks,float netHeadYaw,float headPitch) {
        head.yRot=netHeadYaw*Mth.DEG_TO_RAD*0.5f; head.xRot=headPitch*Mth.DEG_TO_RAD*0.5f;
        leftLeg.xRot=Mth.cos(limbSwing*0.6662f)*1.1f*limbSwingAmount;
        rightLeg.xRot=Mth.cos(limbSwing*0.6662f+Mth.PI)*1.1f*limbSwingAmount;
        backLeft.xRot=rightLeg.xRot; backRight.xRot=leftLeg.xRot;
    }
}
