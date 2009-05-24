/***
 *    This program is free software; you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation; either version 2 of the License, or
 *    (at your option) any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program; if not, write to the Free Software
 *    Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 *    
 *    Linking this library statically or dynamically with other modules 
 *    is making a combined work based on this library. Thus, the terms and
 *    conditions of the GNU General Public License cover the whole
 *    combination.
 *    
 *    As a special exception, the copyright holders of this library give 
 *    you permission to link this library with independent modules to 
 *    produce an executable, regardless of the license terms of these 
 *    independent modules, and to copy and distribute the resulting 
 *    executable under terms of your choice, provided that you also meet, 
 *    for each linked independent module, the terms and conditions of the 
 *    license of that module.  An independent module is a module which 
 *    is not derived from or based on this library.  If you modify this 
 *    library, you may extend this exception to your version of the 
 *    library, but you are not obligated to do so.  If you do not wish 
 *    to do so, delete this exception statement from your version.
 *
 *    Project: www.simpledbm.org
 *    Author : Dibyendu Majumdar
 *    Email  : d dot majumdar at gmail dot com ignore
 */
package org.simpledbm.common.api.registry;

import java.nio.ByteBuffer;

/**
 * A Storable object can be written to (stored into) or read from (retrieved from) 
 * a ByteBuffer. The object must be able to predict its length in bytes; this 
 * not only allows clients to allocate ByteBuffer objects of suitable size, it is also 
 * be used by a StorageContainer to ensure that objects can be restored from
 * secondary storage.
 * <p>Storable objects must provide constructors that accept ByteBuffer as the sole
 * argument. In order to create such objects, implementations of {@link org.simpledbm.common.api.registry.ObjectFactory ObjectFactory} must be
 * registered with the {@link org.simpledbm.common.api.registry.ObjectRegistry ObjectRegistry}.
 * <p>The asymmetry between the way objects are serialized through calling {@link #store(ByteBuffer) store()} and
 * de-serialized using the ObjectFactory is to allow constructor based initialization of
 * objects during de-serialization. This allows objects to be defined as immutable without
 * introducing a back door facility for reading/writing final fields.
 * @author dibyendu
 * @since 10-June-2005
 */
public interface Storable {

    /**
     * Store this object into the supplied ByteBuffer in a format that can 
     * be subsequently used to reconstruct the object. ByteBuffer is assumed
     * to be setup correctly for writing.
     * @param bb ByteBuffer that will a stored representation of the object.
     */
    void store(ByteBuffer bb);

    /**
     * Predict the length of this object in bytes when it will be stored
     * in a ByteBuffer.
     * @return The length of this object when stored in a ByteBuffer.
     */
    int getStoredLength();

}
