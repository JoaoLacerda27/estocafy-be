package com.main.estocafy.shared.security.context;

import java.util.Set;
import java.util.UUID;

public class TenantContextHolder {

    private static final ThreadLocal<UUID> tenantId = new ThreadLocal<>();
    private static final ThreadLocal<Set<UUID>> branchIds = new ThreadLocal<>();

    public static void setTenantId(UUID id) { 
        tenantId.set(id); 
    }

    public static UUID getTenantId() { 
        return tenantId.get(); 
    }

    public static void clearTenantId() { 
        tenantId.remove(); 
    }

    public static void setBranchIds(Set<UUID> ids) { 
        branchIds.set(ids); 
    }

    public static Set<UUID> getBranchIds() { 
        return branchIds.get(); 
    }

    public static void clearBranchIds() { 
        branchIds.remove(); 
    }

    public static void clearAll() {
        clearTenantId();
        clearBranchIds();
    }
}

