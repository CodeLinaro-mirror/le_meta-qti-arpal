include $(TOPDIR)/rules.mk

PKG_NAME:=mcs
PKG_RELEASE:=1
PKG_FIXUP:=autoreconf

LOCAL_SRC:=$(TOPDIR)/qca/src/vendor/qcom/opensource/qal/mcs/
include $(INCLUDE_DIR)/local-development.mk
ifeq ($(DUMP)$(PKG_VERSION),)
  PKG_REV:=$(shell git ls-remote $(PKG_SOURCE_URL) $(PKG_BRANCH) | cut -b -7)
  PKG_VERSION:=g$(PKG_REV)
endif

include $(INCLUDE_DIR)/package.mk

define Package/mcs
  SECTION:=AUDIO
  CATEGORY:=AUDIO
  DEPENDS:= +osal +qal +glib2 +acdb
  MAINTAINER:=QTI MM Audio
  TITLE:=MCS
  SUBMENU:=CASA
endef

define Package/mcs/description
  This package contails mcs
endef

CONFIGURE_ARGS += \
                  --with-openwrt \
                  --with-glib

TARGET_CFLAGS += \
                 -I$(STAGING_DIR)/usr/include/qal/ \
                 -I$(STAGING_DIR)/usr/include/osal/ \
                 -I$(STAGING_DIR)/usr/include/glib-2.0/ \
                 -I$(STAGING_DIR)/usr/include/acdb/ \
                 -I$(STAGING_DIR)/usr/include/acdbdata/ \
                 -DFEATURE_IPQ_OPENWRT

TARGET_LDFLAGS += \
                 -L$(STAGING_DIR)/usr/lib/

define Build/InstallDev
	$(INSTALL_DIR) $(1)/usr/include/mcs/
	$(INSTALL_DIR) $(1)/usr/lib/
	$(CP) $(PKG_BUILD_DIR)/inc/*.h $(1)/usr/include/mcs/
	$(CP) $(PKG_BUILD_DIR)/.libs/libmcs.so $(1)/usr/lib/
endef

define Package/mcs/install
	$(INSTALL_DIR) $(1)/usr/lib/
	$(INSTALL_DIR) $(1)/usr/bin/
	$(INSTALL_BIN) $(PKG_BUILD_DIR)/.libs/libmcs.so $(1)/usr/lib/
	$(INSTALL_BIN) $(PKG_BUILD_DIR)/.libs/mcs_test $(1)/usr/bin/
endef

$(eval $(call BuildPackage,mcs))
