package org.kuali.student.lum.lu.ui.course.client.controllers;

import org.kuali.student.common.ui.client.configurable.mvc.LayoutController;
import org.kuali.student.common.ui.client.mvc.Callback;
import org.kuali.student.common.ui.client.mvc.Controller;
import org.kuali.student.common.ui.client.mvc.View;
import org.kuali.student.common.ui.client.mvc.history.HistoryManager;
import org.kuali.student.common.ui.client.widgets.field.layout.element.SpanPanel;
import org.kuali.student.lum.lu.ui.course.client.views.CurriculumHomeView;
import org.kuali.student.lum.lu.ui.main.client.controllers.ApplicationController;
import org.kuali.student.lum.lu.ui.tools.client.configuration.CatalogBrowserController;
import org.kuali.student.lum.lu.ui.tools.client.configuration.CluSetsManagementController;
import org.kuali.student.lum.program.client.ProgramController;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.user.client.Window;

public class CurriculumHomeController extends LayoutController{
	
	private boolean loaded = false;
	
	private CurriculumHomeView home;
	private SpanPanel panel = new SpanPanel();
	
	private CourseProposalController courseProposalController;
	private LayoutController viewCourseController;
	private LayoutController manageCluSetsController;
	private LayoutController browseCatalogController;
	private LayoutController programController;
	
	public enum LUMViews {
		DEFAULT,
		COURSE_PROPOSAL,
		VIEW_COURSE,
		PROGRAM,
		CLU_SETS,
		COURSE_CATALOG
	}

	public CurriculumHomeController(Controller controller, String name, Enum<?> viewType) {
		super(CurriculumHomeController.class.getName());
		super.setController(controller);
		super.setName(name);
		super.setViewEnum(viewType);
		this.setDefaultView(LUMViews.DEFAULT);
		this.initWidget(panel);
		
		setupDefaultView();
	}
	
	private void setupDefaultView(){
		home = new CurriculumHomeView(this, LUMViews.DEFAULT);
	}
	
	@Override
	protected <V extends Enum<?>> View getView(V viewType) {
		//this is done so the views can have delayed loading
		switch ((LUMViews) viewType) {
			case DEFAULT:
				return home;
			case COURSE_PROPOSAL:
				return getCourseProposalController();
			case VIEW_COURSE:
				return getViewCourseController();
			case PROGRAM:
				return getProgramController();
			case CLU_SETS:
				return getCluSetsController();
			case COURSE_CATALOG:
				return getBrowseCatalogController();
			default:
				return home;
		}
	}
	

	private CourseProposalController getCourseProposalController(){
		 GWT.runAsync(new RunAsyncCallback() {
	          public void onFailure(Throwable caught) {
	        	  Window.alert("Code download failed");
	          }

	          public void onSuccess() {
	        	  courseProposalController = new CourseProposalController();
	          }
	    });
		
		return courseProposalController;
	}
	
	private LayoutController getViewCourseController(){
		if (viewCourseController == null) {
			GWT.runAsync(new RunAsyncCallback() {
		          public void onFailure(Throwable caught) {
		        	  Window.alert("Code download failed");
		          }

		          public void onSuccess() {
		        	  viewCourseController = new ViewCourseController();
		          }
		    });
		}
		return this.viewCourseController;
	}
	
	private LayoutController getProgramController(){
		GWT.runAsync(new RunAsyncCallback() {
	          public void onFailure(Throwable caught) {
	        	  Window.alert("Code download failed");
	          }

	          public void onSuccess() {
	        	  programController = new ProgramController();
	          }
	    });
		return this.programController;
	}
	
	private LayoutController getCluSetsController(){
		GWT.runAsync(new RunAsyncCallback() {
	          public void onFailure(Throwable caught) {
	        	  Window.alert("Code download failed");
	          }

	          public void onSuccess() {
	        	  manageCluSetsController = new CluSetsManagementController();
	          }
	    });
		return manageCluSetsController;
	}
	
	private LayoutController getBrowseCatalogController(){
		GWT.runAsync(new RunAsyncCallback() {
	          public void onFailure(Throwable caught) {
	        	  Window.alert("Code download failed");
	          }

	          public void onSuccess() {
	        	  browseCatalogController = new CatalogBrowserController(CurriculumHomeController.this);
	          }
	    });
		return browseCatalogController;
	}

	@Override
	protected void hideView(View view) {
		ApplicationController.getApplicationViewContainer().clear();
	}

	@Override
	protected void renderView(View view) {
		ApplicationController.getApplicationViewContainer().add(view.asWidget());
	}
	
	public Class<? extends Enum<?>> getViewsEnum() {
		return LUMViews.class;
	}

	@Override
	public Enum<?> getViewEnumValue(String enumValue) {
		return LUMViews.valueOf(enumValue);
	}
	
	@Override
	public void showDefaultView(Callback<Boolean> onReadyCallback) {
		HistoryManager.setLogNavigationHistory(false);
		this.showView(LUMViews.DEFAULT);
		HistoryManager.setLogNavigationHistory(true);
	}
	
	@Override
	public void updateModel() {
		// No model needed here
	}

}
