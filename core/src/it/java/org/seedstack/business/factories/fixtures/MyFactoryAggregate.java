/**
 * Copyright (c) 2013-2016, The SeedStack authors <http://seedstack.org>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
/**
 * 
 */
package org.seedstack.business.factories.fixtures;

import org.seedstack.business.domain.BaseAggregateRoot;

public class MyFactoryAggregate extends BaseAggregateRoot<String> {
	private String id;
	
	
	public MyFactoryAggregate(String id) {
		super();
		this.id = id;
	}


	public MyFactoryAggregate() {
		super();
	}


	@Override
	public String getEntityId() {
		return id;
	}
}
