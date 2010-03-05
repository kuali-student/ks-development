/*
 * Copyright 2009 The Kuali Foundation Licensed under the
 * Educational Community License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may
 * obtain a copy of the License at
 * 
 * http://www.osedu.org/licenses/ECL-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package org.kuali.student.lum.lu.ui.main.client.controller;

import org.kuali.student.common.ui.client.application.ViewContext;
import org.kuali.student.common.ui.client.application.ViewContext.IdType;
import org.kuali.student.common.ui.client.event.ChangeViewActionEvent;
import org.kuali.student.common.ui.client.event.ChangeViewActionHandler;
import org.kuali.student.common.ui.client.mvc.Callback;
import org.kuali.student.common.ui.client.mvc.Controller;
import org.kuali.student.common.ui.client.mvc.DelegatingViewComposite;
import org.kuali.student.common.ui.client.mvc.View;
import org.kuali.student.common.ui.client.mvc.events.LogoutEvent;
import org.kuali.student.common.ui.client.mvc.events.LogoutHandler;
import org.kuali.student.lum.lu.ui.course.client.configuration.course.CourseProposalController;
import org.kuali.student.lum.lu.ui.course.client.configuration.course.ViewCourseController;
import org.kuali.student.lum.lu.ui.home.client.view.HomeMenuController;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;

public class LUMApplicationManager extends Controller {

	private final SimplePanel viewPanel = new SimplePanel();

	private final View homeMenuView = new DelegatingViewComposite(this,	new HomeMenuController());

	private Controller createCourseController = null;
	private DelegatingViewComposite createCourseView;

	private Controller viewCourseController = null;
	private DelegatingViewComposite viewCourseView;

	private boolean loaded = false;

	public LUMApplicationManager() {
		super(LUMApplicationManager.class.getName());
		super.initWidget(viewPanel);
	}

	protected void onLoad() {
		if (!loaded) {
			addApplicationEventHandler(ChangeViewActionEvent.TYPE,
					new ChangeViewActionHandler() {
						@SuppressWarnings("unchecked")
						public void onViewStateChange(ChangeViewActionEvent event) {
							ViewContext context = event.getViewContext();

							if (context != null && context.getId() != null) {
								switch ((LUMViews)event.getViewType()){
									case EDIT_COURSE_PROPOSAL: initCreateCourse(context);break;
									case VIEW_COURSE: initViewCourseFromCourseId(context.getId());
								}
							}

							showView(event.getViewType(), NO_OP_CALLBACK);
						}
					});

			addApplicationEventHandler(LogoutEvent.TYPE, new LogoutHandler() {
				public void onLogout(LogoutEvent event) {
					Window.Location.assign("/j_spring_security_logout");
				}
			});

			loaded = true;
		}
	}

	public enum LUMViews {
		HOME_MENU, CREATE_COURSE, EDIT_COURSE_PROPOSAL, VIEW_COURSE, CREATE_PROGRAM
	}

	@Override
	protected <V extends Enum<?>> View getView(V viewType) {
		switch ((LUMViews) viewType) {
			case HOME_MENU:
				return homeMenuView;
			case CREATE_COURSE:
				return initBlankCreateCourse();
			case EDIT_COURSE_PROPOSAL:
				return createCourseView;
			case VIEW_COURSE:
				initViewCourse();
				return viewCourseView;
			case CREATE_PROGRAM:
				// FIXME replace with program view
				return createCourseView; // createProgramView;
			default:
				return null;
		}
	}

	private View initBlankCreateCourse() {
		ViewContext context = new ViewContext();
		createCourseController = new CourseProposalController(context);
		createCourseView = new DelegatingViewComposite(LUMApplicationManager.this, createCourseController);

		return createCourseView;
	}

	private View initCreateCourse(ViewContext context) {
		createCourseController = new CourseProposalController(context);
		createCourseView = new DelegatingViewComposite(LUMApplicationManager.this, createCourseController);

		return createCourseView;
	}

	private View initViewCourseFromCourseId(String id) {
		initViewCourse();
		((ViewCourseController) viewCourseController).setCourseId(id);

		return viewCourseView;
	}

	private View initViewCourse() {
		if (viewCourseController == null) {
			viewCourseController = new ViewCourseController();
			viewCourseView = new DelegatingViewComposite(LUMApplicationManager.this, viewCourseController);
		}
		
		((ViewCourseController) viewCourseController).clear();

		return viewCourseView;
	}

	// Accessor for get view
	public <V extends Enum<?>> View getControllerView(V viewType) {
		return this.getView(viewType);
	}

	@Override
	protected void hideView(View view) {
		viewPanel.clear();

	}

	@Override
	protected void renderView(View view) {
		viewPanel.setWidget((Composite) view);
	}

	@Override
	public void showDefaultView(final Callback<Boolean> onReadyCallback) {
		final String docId = Window.Location.getParameter("docId");
		if (docId != null) {
			ViewContext context = new ViewContext();
			context.setId(docId);
			context.setIdType(IdType.DOCUMENT_ID);
			initCreateCourse(context);
			this.showView(LUMViews.EDIT_COURSE_PROPOSAL, onReadyCallback);
		} else {
			this.showView(LUMViews.HOME_MENU, onReadyCallback);
		}
	}

	public Class<? extends Enum<?>> getViewsEnum() {
		return LUMViews.class;
	}

	@Override
	public Enum<?> getViewEnumValue(String enumValue) {
		return LUMViews.valueOf(enumValue);
	}
}
