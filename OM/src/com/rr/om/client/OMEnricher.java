/*******************************************************************************
 * Copyright (c) 2015 Low Latency Trading Limited  :  Author Richard Rose
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at	http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,  software distributed under the License 
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 *******************************************************************************/
package com.rr.om.client;

import com.rr.core.model.Enricher;
import com.rr.model.generated.internal.events.interfaces.MarketCancelReplaceRequestUpdate;
import com.rr.model.generated.internal.events.interfaces.MarketNewOrderSingleUpdate;
import com.rr.om.order.Order;

public interface OMEnricher extends Enricher {

    /**
     * run exchange specific enrichment for client to market messages
     * 
     * eg set market specific order capacity 
     * 
     * if change event fields in mnos then must update the version copies as well
     * 
     * @param order
     * @param mnos
     */
    public void enrich( Order order, MarketNewOrderSingleUpdate mnos );

    /**
     * run exchange specific enrichment for client to market messages
     * 
     * eg set market specific order capacity 
     * 
     * if change event fields in mrep then must update the version copies as well
     * 
     * @param order
     * @param mrep
     */
    public void enrich( Order order, MarketCancelReplaceRequestUpdate mrep );
}
