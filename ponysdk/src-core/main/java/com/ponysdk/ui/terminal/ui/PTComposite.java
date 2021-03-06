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

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.ponysdk.ui.terminal.UIService;
import com.ponysdk.ui.terminal.instruction.PTInstruction;

public abstract class PTComposite extends PTWidget<Composite> {

    private UIService uiService;
    private PTInstruction create;

    @Override
    public void create(final PTInstruction create, final UIService uiService) {
        this.create = create;
        this.uiService = uiService;
    }

    protected void initWidget(final PTWidget<?> widget) {
        init(create, uiService, new MyComposite(widget.cast()));
    }

    protected void initWidget(final Widget widget) {
        init(create, uiService, new MyComposite(widget));
    }

    class MyComposite extends Composite {

        public MyComposite(final Widget widget) {
            initWidget(widget);
        }
    }
}
