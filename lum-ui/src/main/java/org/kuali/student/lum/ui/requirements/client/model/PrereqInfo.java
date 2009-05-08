package org.kuali.student.lum.ui.requirements.client.model;

import java.util.ArrayList;
import java.util.List;

import org.kuali.student.common.ui.client.widgets.table.Node;
import org.kuali.student.core.dto.Idable;
import org.kuali.student.lum.lu.dto.LuStatementInfo;
import org.kuali.student.lum.lu.typekey.StatementOperatorTypeKey;

public class PrereqInfo implements Idable {

    private String cluId;
    private StatementVO statementVO;
    private String rationale;
    private String naturalLanguage;
//    private NodeConverter nodeConverter = new NodeConverter();

    
    @Override
    public String getId() {
        return cluId;
    }
    @Override
    public void setId(String id) {
        this.cluId = id;
    }
    public String getCluId() {
        return cluId;
    }
    public void setCluId(String cluId) {
        this.cluId = cluId;
    }
    public String getRationale() {
        return rationale;
    }
    public void setRationale(String rationale) {
        this.rationale = rationale;
    }
    public String getNaturalLanguage() {
        return naturalLanguage;
    }
    public void setNaturalLanguage(String naturalLanguage) {
        this.naturalLanguage = naturalLanguage;
    }
    
    public StatementVO getStatementVO() {
        return statementVO;
    }
    
    public void setStatementVO(StatementVO statementVO) {
        this.statementVO = statementVO;
    }
    
    public Node getStatementTree() {
        Node tree = null;
        if (statementVO != null) {          
            tree = statementVO.getTree();
        }
        return tree;
    }
    
    private boolean statementVOIsGroupAble(
            List<StatementVO> selectedStatementVOs,
            List<ReqComponentVO> selectedReqComponentVOs) {
        boolean orable = false;
        StatementVO enclosingStatement = null;
        boolean reqComponentsInSameGroup = true;
        int numStatementsSelection = (selectedStatementVOs == null)? 0 : 
            selectedStatementVOs.size();
        int numReqComponentSelection = (selectedReqComponentVOs == null)? 0 :
            selectedReqComponentVOs.size();
        int numSelection = numStatementsSelection + numReqComponentSelection;
        
        // At least 2 items (StatementVO or RC) must be selected.
        if (numSelection >= 2) {
            if (numStatementsSelection > 0) {
                enclosingStatement = this.statementVO.getParentStatementVO(this.statementVO,
                        selectedStatementVOs.get(0));
            } else {
                enclosingStatement = this.statementVO.getEnclosingStatementVO(this.statementVO,
                        selectedReqComponentVOs.get(0));
            }
            
            if (numStatementsSelection > 0) {
                for (StatementVO selectedStatementVO : selectedStatementVOs) {
                    StatementVO enclosingStatement2 = this.statementVO.getParentStatementVO(
                            this.statementVO, selectedStatementVO);
                    if (enclosingStatement != enclosingStatement2) {
                        reqComponentsInSameGroup = false;
                        break;
                    }
                }
            }
            if (numReqComponentSelection > 0) {
                for (ReqComponentVO selectedReqCompoentVO : selectedReqComponentVOs) {
                    StatementVO enclosingStatement2 = this.statementVO.getEnclosingStatementVO(
                            this.statementVO, selectedReqCompoentVO);
                    if (enclosingStatement != enclosingStatement2) {
                        reqComponentsInSameGroup = false;
                        break;
                    }
                }
            }
            
            // the items selected must all belong to the same group
            if (!reqComponentsInSameGroup) return false;
            
            int childCount = (enclosingStatement == null)? 0 : enclosingStatement
                        .getChildCount();
            
            // number of selected requirement components must be less the the total number of
            // requirement components of the enclosing statement
            if (selectedReqComponentVOs != null && !selectedReqComponentVOs.isEmpty() &&
                    childCount > numSelection) {
                orable = true;
            } else {
                orable = false;
            }
        } else {
            orable = false;
        }
        return orable;
    }

    public boolean statementVOIsGroupAble() {
        List<StatementVO> selectedStatementVOs = getSelectedStatementVOs();
        List<ReqComponentVO> selectedReqComponentVOs = getSelectedReqComponentVOs();
        return statementVOIsGroupAble(selectedStatementVOs, selectedReqComponentVOs);
    }
    
    public void insertOR() {
        List<StatementVO> selectedStatementVOs = getSelectedStatementVOs();
        List<ReqComponentVO> selectedReqComponentVOs = getSelectedReqComponentVOs();
        // check if the selections can be grouped by OR operator.
        if (!statementVOIsGroupAble(selectedStatementVOs, selectedReqComponentVOs)) return;
        StatementVO enclosingStatementVO = statementVO.getEnclosingStatementVO(statementVO,
                selectedReqComponentVOs.get(0));
        // create new statement to hold the new OR group
        StatementVO newStatementVO = new StatementVO();
        LuStatementInfo newLuStatementInfo = new LuStatementInfo();
        newLuStatementInfo.setOperator(StatementOperatorTypeKey.OR);
        newStatementVO.setLuStatementInfo(newLuStatementInfo);
        // remove the selected RCs from original statement and move them into the new
        // StatementVO
        for (ReqComponentVO selectedReqComponentVO : selectedReqComponentVOs) {
            enclosingStatementVO.removeReqComponentVO(selectedReqComponentVO);
            newStatementVO.addReqComponentVO(selectedReqComponentVO);
        }
        // remove the selected StatementVOs from original statement and move them into
        // the new StatementVO
        for (StatementVO selectedStatementVO : selectedStatementVOs) {
            enclosingStatementVO.removeStatementVO(selectedStatementVO);
            newStatementVO.addStatementVO(selectedStatementVO);
        }
        enclosingStatementVO.addStatementVO(newStatementVO);
    }
    
    public void insertAND() {
        List<StatementVO> selectedStatementVOs = getSelectedStatementVOs();
        List<ReqComponentVO> selectedReqComponentVOs = getSelectedReqComponentVOs();
        // check if the selections can be grouped by OR operator.
        if (!statementVOIsGroupAble(selectedStatementVOs, selectedReqComponentVOs)) return;
        StatementVO enclosingStatementVO = statementVO.getEnclosingStatementVO(statementVO,
                selectedReqComponentVOs.get(0));
        // create new statement to hold the new OR group
        StatementVO newStatementVO = new StatementVO();
        LuStatementInfo newLuStatementInfo = new LuStatementInfo();
        newLuStatementInfo.setOperator(StatementOperatorTypeKey.AND);
        newStatementVO.setLuStatementInfo(newLuStatementInfo);
        // remove the selected RCs from original statement and move them into the new
        // StatementVO
        for (ReqComponentVO selectedReqComponentVO : selectedReqComponentVOs) {
            enclosingStatementVO.removeReqComponentVO(selectedReqComponentVO);
            newStatementVO.addReqComponentVO(selectedReqComponentVO);
        }
        // remove the selected StatementVOs from original statement and move them into
        // the new StatementVO
        for (StatementVO selectedStatementVO : selectedStatementVOs) {
            enclosingStatementVO.removeStatementVO(selectedStatementVO);
            newStatementVO.addStatementVO(selectedStatementVO);
        }
        enclosingStatementVO.addStatementVO(newStatementVO);
    }
    
    public boolean statementVOIsDegroupAble() {
        List<StatementVO> selectedStatementVOs = getSelectedStatementVOs();
        List<ReqComponentVO> selectedReqComponentVOs = getSelectedReqComponentVOs();
        return statementVOIsDegroupAble(selectedStatementVOs, selectedReqComponentVOs);
    }
    
    private boolean statementVOIsDegroupAble(
            List<StatementVO> selectedStatementVOs,
            List<ReqComponentVO> selectedReqComponentVOs) {
        boolean degroupAble = false;
        boolean selectedRootStatementVO = false;
        boolean otherItemsExist = false;
        // at least one item is selected
        if ((selectedStatementVOs != null && !selectedStatementVOs.isEmpty()) || 
                (selectedReqComponentVOs != null && !selectedReqComponentVOs.isEmpty())) {
            degroupAble = true;
        } else {
            return false;
        }
        
        // root statement should not be selected if there are other items.
        for (StatementVO selectedStatement : selectedStatementVOs) {
            if (selectedStatement == this.statementVO) {
                selectedRootStatementVO = true;
                break;
            }
        }
        otherItemsExist = this.statementVO.getChildCount() > 0;
        if (selectedRootStatementVO && otherItemsExist) {
            degroupAble = degroupAble && false;
        } else{
            degroupAble = degroupAble && true;
        }
        
        // must leave at least 2 children in a group unselected or
        // all children are RCs and are selected.
        for (ReqComponentVO selectedRC : selectedReqComponentVOs) {
            StatementVO parentStatementVO = 
                this.statementVO.getEnclosingStatementVO(this.statementVO,
                        selectedRC);
            int numSelectedChildren = 0;
            int numSelectedChildrenRC = 0;
            if (parentStatementVO.getStatementVOCount() > 0) {
                for (StatementVO subStatementVO : 
                    parentStatementVO.getStatementVOs()) {
                    if (subStatementVO.isWrapperStatementVO() &&
                            subStatementVO.getReqComponentVOs().get(0).isCheckBoxOn()) {
                        numSelectedChildren++;
                    } else if (subStatementVO.isCheckBoxOn()) {
                        numSelectedChildren++;
                    }
                }
            } else if (parentStatementVO.getReqComponentVOCount() > 0) {
                for (ReqComponentVO rcVO : parentStatementVO.getReqComponentVOs()) {
                    if (rcVO.isCheckBoxOn()) {
                        numSelectedChildren++;
                        numSelectedChildrenRC++;
                    }
                }
            }
            if (parentStatementVO.getChildCount() - numSelectedChildren > 1) {
                degroupAble = degroupAble && true;
            } else if (numSelectedChildrenRC == parentStatementVO.getChildCount()) {
                degroupAble = degroupAble && true;
            } else {
                degroupAble = degroupAble && false;
            }
        }
        return degroupAble;
    }
    
    public void deleteItem() {
        List<StatementVO> selectedStatementVOs = getSelectedStatementVOs();
        List<ReqComponentVO> selectedReqComponentVOs = getSelectedReqComponentVOs();
        if (!statementVOIsDegroupAble(selectedStatementVOs, selectedReqComponentVOs)) return;
        for (ReqComponentVO selectedReqComponent : selectedReqComponentVOs) {
            StatementVO parentStatementVO = null;
            parentStatementVO =
                this.statementVO.getEnclosingStatementVO(this.statementVO, selectedReqComponent);
            parentStatementVO.removeReqComponentVO(selectedReqComponent);
        }
        for (StatementVO selectedStatement : selectedStatementVOs) {
            StatementVO parentStatementVO = null; 
            parentStatementVO = 
                this.statementVO.getParentStatementVO(this.statementVO, selectedStatement);
            
            if (selectedStatement == statementVO) {
                statementVO = null;
            } else if (parentStatementVO != null) {
                parentStatementVO.removeStatementVO(selectedStatement);
                if (selectedStatement.getStatementVOCount() > 0) {
                    for (StatementVO subStatement : selectedStatement.getStatementVOs()) {
                        parentStatementVO.addStatementVO(subStatement);
                    }
                } else if (selectedStatement.getReqComponentVOCount() > 0) {
                    for (ReqComponentVO leafReqComponent : selectedStatement.getReqComponentVOs()) {
                        parentStatementVO.addReqComponentVO(leafReqComponent);
                    }
                }
                // clean up wrapper statements
                if (parentStatementVO.getStatementVOCount() > 0 &&
                        parentStatementVO.getReqComponentVOCount() == 0) {
                    boolean allStatementsWrapped = true;
                    List<ReqComponentVO> wrappedRCs = new ArrayList<ReqComponentVO>();
                    for (StatementVO subStatementVO : 
                        parentStatementVO.getStatementVOs()) {
                        if (subStatementVO.isWrapperStatementVO()) {
                            wrappedRCs.add(subStatementVO.getReqComponentVOs().get(0));
                        } else {
                            allStatementsWrapped = false;
                            break;
                        }
                    }
                    if (allStatementsWrapped) {
                        List<StatementVO> tempStatementVOs =
                            new ArrayList<StatementVO>(parentStatementVO.getStatementVOs());
                        for (StatementVO subStatementVO : tempStatementVOs) {
                            parentStatementVO.removeStatementVO(subStatementVO);
                        }
                        for (ReqComponentVO wrappedReqComponentVO : wrappedRCs) {
                            parentStatementVO.addReqComponentVO(wrappedReqComponentVO);
                        }
                    }
                }
            }
        }
    }
    
    public boolean isAddToGroupOK() {
        List<StatementVO> selectedStatementVOs = getSelectedStatementVOs();
        List<ReqComponentVO> selectedReqComponentVOs = getSelectedReqComponentVOs();
        return isAddToGroupOK(selectedStatementVOs, selectedReqComponentVOs);
    }
    
    private boolean isAddToGroupOK(List<StatementVO> selectedStatementVOs,
            List<ReqComponentVO> selectedReqComponentVOs) {
        boolean addToGroupOk = false;
        int numSelectedS = (selectedStatementVOs == null)? 0 : selectedStatementVOs.size();
        int numSelectedRC = (selectedReqComponentVOs == null)? 0 :
            selectedReqComponentVOs.size();
        // one or more rules are selected as well as a single AND or OR cell
        addToGroupOk = numSelectedS == 1 && numSelectedRC > 0;
        return addToGroupOk;
    }
    
    public void addToGroup() {
        List<StatementVO> selectedStatementVOs = getSelectedStatementVOs();
        List<ReqComponentVO> selectedReqComponentVOs = getSelectedReqComponentVOs();
        if (!isAddToGroupOK(selectedStatementVOs, selectedReqComponentVOs)) return;
        if (selectedReqComponentVOs != null &&
                !selectedReqComponentVOs.isEmpty()) {
            for (ReqComponentVO selectedRC : selectedReqComponentVOs) {
                StatementVO parentS = this.statementVO.getEnclosingStatementVO(
                    this.statementVO, selectedRC);
                if (parentS == null) continue;
                parentS.removeReqComponentVO(selectedRC);
                selectedStatementVOs.get(0).addReqComponentVO(selectedRC);
            }
            statementVO.cleanupStatementVO();
//            statementVO.unwrapRCs();
        }
    }
    
    public List<StatementVO> getSelectedStatementVOs() {
        return (statementVO == null)? null : statementVO.getSelectedStatementVOs();
    }
    
    public List<ReqComponentVO> getSelectedReqComponentVOs() {
        return (statementVO == null)? null : statementVO.getSelectedReqComponentVOs();
    }

}
