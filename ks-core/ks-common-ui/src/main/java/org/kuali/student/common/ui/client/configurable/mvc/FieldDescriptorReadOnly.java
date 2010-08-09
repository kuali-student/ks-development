package org.kuali.student.common.ui.client.configurable.mvc;

import org.kuali.student.common.ui.client.widgets.KSLabel;
import org.kuali.student.common.ui.client.widgets.KSTextBox;
import org.kuali.student.common.ui.client.widgets.field.layout.element.MessageKeyInfo;
import org.kuali.student.core.assembly.data.Metadata;

import com.google.gwt.user.client.ui.Widget;

public class FieldDescriptorReadOnly extends FieldDescriptor{

	public FieldDescriptorReadOnly(String fieldKey, MessageKeyInfo messageKey,
			Metadata metadata) {
		super(fieldKey, messageKey, metadata);
	}
	
	public FieldDescriptorReadOnly(String fieldKey, MessageKeyInfo messageKey,
			Metadata metadata, Widget widget) {
		super(fieldKey, messageKey, metadata, widget);
	}

	
	@Override
	protected Widget createFieldWidget() {
    	if (metadata == null) {
	    	Widget result = new KSLabel();
	    	if(fieldKey != null){
	    		String style = this.fieldKey.replaceAll("/", "-");
	    		style = style + "-readOnly";
	    		result.addStyleName(style);
	    	}
	    	return result;
    	} else {
    		Widget result = DefaultWidgetFactory.getInstance().getReadOnlyWidget(metadata);
	    	if(fieldKey != null && !fieldKey.isEmpty()){
	    		String style = this.fieldKey.replaceAll("/", "-");
	    		style = style + "-readOnly";
	    		result.addStyleName(style);
	    	}
    		return result;
    	}
	}
}
