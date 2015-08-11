/*******************************************************************************
 * Copyright (c) 2015 Low Latency Trading Limited  :  Author Richard Rose
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at	http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,  software distributed under the License 
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 *******************************************************************************/
package com.rr.model.generated.internal.events.recycle;

import com.rr.model.generated.internal.events.impl.ClientCancelReplaceRequestImpl;
import com.rr.core.pool.Recycler;
import com.rr.core.pool.SuperPool;
import com.rr.core.pool.RuntimePoolingException;

public class ClientCancelReplaceRequestRecycler implements Recycler<ClientCancelReplaceRequestImpl> {

    private SuperPool<ClientCancelReplaceRequestImpl> _superPool;

    private ClientCancelReplaceRequestImpl _root;

    private int          _recycleSize;
    private int          _count = 0;
    public ClientCancelReplaceRequestRecycler( int recycleSize, SuperPool<ClientCancelReplaceRequestImpl> superPool ) {
        _superPool = superPool;
        _recycleSize = recycleSize;
        try {
            _root    = ClientCancelReplaceRequestImpl.class.newInstance();
        } catch( Exception e ) {
            throw new RuntimePoolingException( "Unable to create recycle root for ClientCancelReplaceRequestImpl : " + e.getMessage(), e );
        }
    }


    @Override public void recycle( ClientCancelReplaceRequestImpl obj ) {
        if ( obj.getNext() == null ) {
            obj.reset();
            obj.setNext( _root.getNext() );
            _root.setNext( obj );
            if ( ++_count == _recycleSize ) {
                _superPool.returnChain( _root.getNext() );
                _root.setNext( null );
                _count = 0;
            }
        }
    }
}
