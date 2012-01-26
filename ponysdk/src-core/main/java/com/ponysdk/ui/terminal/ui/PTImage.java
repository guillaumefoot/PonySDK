/*
 * Copyright (c) 2011 PonySDK
 *  Owners:
 *  Luciano Broussal  <luciano.broussal AT gmail.com>
 *	Mathieu Barbier   <mathieu.barbier AT gmail.com>
 *	Nicolas Ciaravola <nicolas.ciaravola.pro AT gmail.com>
 *  
 *  WebSite:
 *  http://code.google.com/p/pony-sdk/
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.ponysdk.ui.terminal.ui;

import com.google.gwt.core.client.GWT;
import com.ponysdk.ui.terminal.HandlerType;
import com.ponysdk.ui.terminal.Property;
import com.ponysdk.ui.terminal.PropertyKey;
import com.ponysdk.ui.terminal.UIBuilder;
import com.ponysdk.ui.terminal.UIService;
import com.ponysdk.ui.terminal.instruction.AddHandler;
import com.ponysdk.ui.terminal.instruction.Create;
import com.ponysdk.ui.terminal.instruction.Update;

public class PTImage extends PTWidget {

    @Override
    public void create(Create create, UIService uiService) {
        init(new com.google.gwt.user.client.ui.Image());
    }

    @Override
    public void addHandler(AddHandler addHandler, UIService uiService) {
        if (HandlerType.EMBEDED_STREAM_REQUEST_HANDLER.equals(addHandler.getType())) {
            cast().setUrl(GWT.getModuleBaseURL() + "stream?" + "ponySessionID=" + UIBuilder.sessionID + "&" + PropertyKey.STREAM_REQUEST_ID.name() + "=" + addHandler.getMainProperty().getValue());
            return;
        }

        super.addHandler(addHandler, uiService);
    }

    @Override
    public void update(Update update, UIService uiService) {

        final Property property = update.getMainProperty();
        final PropertyKey propertyKey = property.getKey();
        if (PropertyKey.IMAGE_URL.equals(propertyKey)) {
            cast().setUrl(property.getValue());
            return;
        }

        super.update(update, uiService);
    }

    @Override
    public com.google.gwt.user.client.ui.Image cast() {
        return (com.google.gwt.user.client.ui.Image) uiObject;
    }
}
