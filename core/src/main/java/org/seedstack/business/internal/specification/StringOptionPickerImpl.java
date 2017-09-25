/*
 * Copyright © 2013-2017, The SeedStack authors <http://seedstack.org>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.seedstack.business.internal.specification;

import org.seedstack.business.specification.dsl.BaseSelector;
import org.seedstack.business.specification.dsl.StringOptionPicker;

class StringOptionPickerImpl<T, SelectorT extends BaseSelector<T, SelectorT>> extends
    OperatorPickerImpl<T, SelectorT> implements StringOptionPicker<T, SelectorT> {

  private final StringValueOptionsImpl stringValueOptions;

  StringOptionPickerImpl(SpecificationBuilderContext<T, SelectorT> context,
      StringValueOptionsImpl stringValueOptions) {
    super(context);
    this.stringValueOptions = stringValueOptions;
  }

  @Override
  public StringOptionPicker<T, SelectorT> trimming() {
    stringValueOptions.setTrimmed(true);
    return this;
  }

  @Override
  public StringOptionPicker<T, SelectorT> trimmingLead() {
    stringValueOptions.setLeftTrimmed(true);
    return this;
  }

  @Override
  public StringOptionPicker<T, SelectorT> trimmingTail() {
    stringValueOptions.setRightTrimmed(true);
    return this;
  }

  @Override
  public StringOptionPicker<T, SelectorT> ignoringCase() {
    stringValueOptions.setIgnoringCase(true);
    return this;
  }
}