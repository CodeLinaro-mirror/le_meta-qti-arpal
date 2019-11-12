include $(TOPDIR)/rules.mk

PKG_NAME:=adie_rtc
PKG_RELEASE:=1
PKG_FIXUP:=autoreconf

LOCAL_SRC:=$(TOPDIR)/qca/src/vendor/qcom/opensource/qal/adie_rtc/
include $(INCLUDE_DIR)/local-development.mk
ifeq ($(DUMP)$(PKG_VERSION),)
  PKG_REV:=$(shell git ls-remote $(PKG_SOURCE_URL) $(PKG_BRANCH) | cut -b -7)
  PKG_VERSION:=g$(PKG_REV)
endif

include $(INCLUDE_DIR)/package.mk

define Package/adie_rtc
  SECTION:=AUDIO
  CATEGORY:=AUDIO
  DEPENDS:= +osal +qal
  MAINTAINER:=QTI MM Audio
  TITLE:=MCS
  SUBMENU:=CASA
endef

define Package/adie_rtc/description
  This package contails adie_rtc
endef

CONFIGURE_ARGS += \
                  --with-openwrt \
                  --with-glib

TARGET_CFLAGS += \
                 -I$(STAGING_DIR)/usr/include/qal/ \
                 -I$(STAGING_DIR)/usr/include/osal/ \
                 -DFEATURE_IPQ_OPENWRT

TARGET_LDFLAGS += \
                 -L$(STAGING_DIR)/usr/lib/

define Build/InstallDev
	$(INSTALL_DIR) $(1)/usr/include/adie_rtc/
	$(INSTALL_DIR) $(1)/usr/lib/
	$(CP) $(PKG_BUILD_DIR)/inc/*.h $(1)/usr/include/adie_rtc/
	$(CP) $(PKG_BUILD_DIR)/.libs/libadie_rtc.so $(1)/usr/lib/
endef

define Package/adie_rtc/install
	$(INSTALL_DIR) $(1)/usr/lib/
	$(INSTALL_DIR) $(1)/usr/bin/
	$(INSTALL_BIN) $(PKG_BUILD_DIR)/.libs/libadie_rtc.so $(1)/usr/lib/
	$(INSTALL_BIN) $(PKG_BUILD_DIR)/.libs/adie_rtc_test $(1)/usr/bin/
endef

$(eval $(call BuildPackage,adie_rtc))
