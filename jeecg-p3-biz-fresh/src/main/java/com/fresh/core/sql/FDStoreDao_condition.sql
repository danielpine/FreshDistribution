		<#if ( fDStore.location )?? && fDStore.location ?length gt 0>
		    /* location */
			and fds.location = :fDStore.location
		</#if>
		<#if ( fDStore.name )?? && fDStore.name ?length gt 0>
		    /* name */
			and fds.name = :fDStore.name
		</#if>
		<#if ( fDStore.type )?? && fDStore.type ?length gt 0>
		    /* type */
			and fds.type = :fDStore.type
		</#if>
