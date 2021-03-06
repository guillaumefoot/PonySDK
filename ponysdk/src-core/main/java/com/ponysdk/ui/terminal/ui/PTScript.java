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

import com.ponysdk.ui.terminal.Dictionnary.PROPERTY;
import com.ponysdk.ui.terminal.Dictionnary.TYPE;
import com.ponysdk.ui.terminal.UIService;
import com.ponysdk.ui.terminal.instruction.PTInstruction;

public class PTScript extends AbstractPTObject {

    @Override
    public void update(final PTInstruction update, final UIService uiService) {

        final String scriptToEval = update.getString(PROPERTY.EVAL);
        try {
            final Object result = eval(scriptToEval);

            final PTInstruction eventInstruction = new PTInstruction();
            eventInstruction.setObjectID(update.getObjectID());
            eventInstruction.put(TYPE.KEY, TYPE.KEY_.EVENT);
            eventInstruction.put(PROPERTY.ID, update.getLong(PROPERTY.ID));
            eventInstruction.put(PROPERTY.RESULT, result == null ? "" : result.toString());
            uiService.triggerEvent(eventInstruction);
        } catch (final Throwable e) {
            final PTInstruction eventInstruction = new PTInstruction();
            eventInstruction.setObjectID(update.getObjectID());
            eventInstruction.put(TYPE.KEY, TYPE.KEY_.EVENT);
            eventInstruction.put(PROPERTY.ID, update.getLong(PROPERTY.ID));
            eventInstruction.put(PROPERTY.ERROR_MSG, e.getMessage());
            uiService.triggerEvent(eventInstruction);
        }
    }

    public static native Object eval(String script) /*-{
                                                     var r = $wnd.eval(script);
                                                     if (typeof r=="object") return JSON.stringify(r);
                                                     else return r;
                                                     }-*/;
}
