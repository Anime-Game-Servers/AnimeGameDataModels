package org.anime_game_servers.game_data_models.gi.data.trial

interface TrialAvatarLoadout {
    val trialAvatarSkillLevel: Int
    val trialSkillDepotId: Int
    val trialReliquaryList: List<Int>?
    val trialTalentList: List<Int>?

    fun getAvatarLevel(): Int

    fun hasAvatarSkillLevel() = trialAvatarSkillLevel > 0
    fun hasTrialSkillDepotId() = trialSkillDepotId > 0
    fun hasAvatarLevel() = getAvatarLevel() > 0
    fun hasReliquaryList() = trialReliquaryList != null
    fun hasTalentList() = trialTalentList != null

}
