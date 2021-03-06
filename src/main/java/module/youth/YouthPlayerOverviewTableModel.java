package module.youth;

import core.gui.comp.entry.ColorLabelEntry;
import core.gui.comp.entry.IHOTableEntry;
import core.gui.comp.table.HOTableModel;
import core.gui.model.YouthPlayerColumn;
import core.model.HOVerwaltung;
import core.model.player.Player;
import module.training.Skills;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class YouthPlayerOverviewTableModel extends HOTableModel {

    public YouthPlayerOverviewTableModel(int id) {
        super(id,"YouthPlayerOverview");
        columns =  initColumns();
    }

    private YouthPlayerColumn[] initColumns() {
        return new YouthPlayerColumn[]{
                // TODO: Name column should include the specialty icon
                new YouthPlayerColumn(0, "ls.player.name") {
                    @Override
                    public IHOTableEntry getTableEntry(YouthPlayer player, YouthPlayer playerCompare) {
                        return new ColorLabelEntry(player.getFullName(), ColorLabelEntry.FG_STANDARD, ColorLabelEntry.BG_STANDARD, SwingConstants.LEFT);
                    }
                },
                new YouthPlayerColumn(1, "ls.player.age") {
                    @Override
                    public IHOTableEntry getTableEntry(YouthPlayer player, YouthPlayer playerCompare) {
                        return new ColorLabelEntry(Player.getAgeWithDaysAsString(player.getAgeYears(), player.getAgeDays(), new Date().getTime()), ColorLabelEntry.FG_STANDARD, ColorLabelEntry.BG_STANDARD, SwingConstants.LEFT);
                    }
                },
                new YouthPlayerColumn(2, "ls.youth.player.arrival") {
                    @Override
                    public IHOTableEntry getTableEntry(YouthPlayer player, YouthPlayer playerCompare) {
                        return new ColorLabelEntry(new SimpleDateFormat("yyyy-MM-dd hh:mm").format(player.getArrivalDate()), ColorLabelEntry.FG_STANDARD, ColorLabelEntry.BG_STANDARD, SwingConstants.LEFT);
                    }
                },
                new YouthPlayerColumn(3, "ls.youth.player.canBePromotedIn") {
                    @Override
                    public IHOTableEntry getTableEntry(YouthPlayer player, YouthPlayer playerCompare) {
                        return new ColorLabelEntry("" + player.getCanBePromotedInAtDate(new Date().getTime()), ColorLabelEntry.FG_STANDARD, ColorLabelEntry.BG_STANDARD, SwingConstants.RIGHT);
                    }
                },
                // TODO minWidth does not work
                new YouthPlayerColumn(4, "ls.youth.player.Keeper", 200) {
                    @Override
                    public IHOTableEntry getTableEntry(YouthPlayer player, YouthPlayer playerCompare) {
                        return new SkillInfoColumn(player.getSkillInfo(Skills.HTSkillID.Keeper));
                    }
                },
                new YouthPlayerColumn(5, "ls.youth.player.Defender") {
                    @Override
                    public IHOTableEntry getTableEntry(YouthPlayer player, YouthPlayer playerCompare) {
                        return new SkillInfoColumn(player.getSkillInfo(Skills.HTSkillID.Defender));
                    }
                },
                new YouthPlayerColumn(6, "ls.youth.player.Playmaker") {
                    @Override
                    public IHOTableEntry getTableEntry(YouthPlayer player, YouthPlayer playerCompare) {
                        return new SkillInfoColumn(player.getSkillInfo(Skills.HTSkillID.Playmaker));
                    }
                },
                new YouthPlayerColumn(7, "ls.youth.player.Winger") {
                    @Override
                    public IHOTableEntry getTableEntry(YouthPlayer player, YouthPlayer playerCompare) {
                        return new SkillInfoColumn(player.getSkillInfo(Skills.HTSkillID.Winger));
                    }
                },
                new YouthPlayerColumn(8, "ls.youth.player.Passing") {
                    @Override
                    public IHOTableEntry getTableEntry(YouthPlayer player, YouthPlayer playerCompare) {
                        return new SkillInfoColumn(player.getSkillInfo(Skills.HTSkillID.Passing));
                    }
                },
                new YouthPlayerColumn(9, "ls.youth.player.Scorer") {
                    @Override
                    public IHOTableEntry getTableEntry(YouthPlayer player, YouthPlayer playerCompare) {
                        return new SkillInfoColumn(player.getSkillInfo(Skills.HTSkillID.Scorer));
                    }
                },
                new YouthPlayerColumn(10, "ls.youth.player.SetPieces") {
                    @Override
                    public IHOTableEntry getTableEntry(YouthPlayer player, YouthPlayer playerCompare) {
                        return new SkillInfoColumn(player.getSkillInfo(Skills.HTSkillID.SetPieces));
                    }
                },

                new YouthPlayerColumn(99, "ls.player.id", 0) {
                    @Override
                    public boolean isDisplay() {
                        return false;
                    }
                }
        };
    }

    @Override
    protected void initData() {
        var youthplayers = HOVerwaltung.instance().getModel().getCurrentYouthPlayers();
        m_clData = new Object[youthplayers.size()][columns.length];
        int playernum=0;
        for ( var player: youthplayers ) {
            int columnnum=0;
            for (var col: columns){
                m_clData[playernum][columnnum] = ((YouthPlayerColumn)col).getTableEntry(player, null);
                columnnum++;
            }
            playernum++;
        }
        fireTableDataChanged();
    }
}
