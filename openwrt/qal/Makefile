include $(TOPDIR)/rules.mk

PKG_NAME:=qal
PKG_RELEASE:=1
PKG_FIXUP:=autoreconf

LOCAL_SRC:=$(TOPDIR)/qca/src/vendor/qcom/opensource/qal
include $(INCLUDE_DIR)/local-development.mk
ifeq ($(DUMP)$(PKG_VERSION),)
  PKG_REV:=$(shell git ls-remote $(PKG_SOURCE_URL) $(PKG_BRANCH) | cut -b -7)
  PKG_VERSION:=g$(PKG_REV)
endif

include $(INCLUDE_DIR)/package.mk

define Package/qal
  SECTION:=AUDIO
  CATEGORY:=AUDIO
  DEPENDS:= +tinyalsa +audio-utils +libstdcpp +gsl +glib2 +libexpat +capiv2-headers
  MAINTAINER:=QTI MM Audio
  TITLE:=QAL
  SUBMENU:=CASA
endef

define Package/qal/description
  This package contails qal
endef

CONFIGURE_ARGS += \
                  --with-openwrt

TARGET_CFLAGS += \
                 -I$(STAGING_DIR)/usr/include/osal/ \
                 -I$(STAGING_DIR)/usr/include/gsl/ \
                 -I$(STAGING_DIR)/usr/include/gecko/ \
                 -I$(STAGING_DIR)/usr/include/audio_route/ \
                 -I$(STAGING_DIR)/usr/include/glib-2.0/ \
                 -I$(STAGING_DIR)/usr/include/capiv2_headers/

TARGET_LDFLAGS += \
                 -L$(STAGING_DIR)/usr/lib/

define Build/InstallDev
	$(INSTALL_DIR) $(1)/usr/include/qal/
	$(INSTALL_DIR) $(1)/usr/lib/
	$(CP) $(PKG_BUILD_DIR)/*.h $(1)/usr/include/qal/
	$(CP) $(PKG_BUILD_DIR)/device/inc/ $(1)/usr/include/qal/
	$(CP) $(PKG_BUILD_DIR)/resource_manager/inc/ $(1)/usr/include/qal/
	$(CP) $(PKG_BUILD_DIR)/session/inc/ $(1)/usr/include/qal/
	$(CP) $(PKG_BUILD_DIR)/stream/inc/ $(1)/usr/include/qal/
	$(CP) $(PKG_BUILD_DIR)/utils/inc/ $(1)/usr/include/qal/
	$(CP) $(PKG_BUILD_DIR)/.libs/libqal.so $(1)/usr/lib/
endef

define Package/qal/install
	$(INSTALL_DIR) $(1)/usr/lib
	$(INSTALL_DIR) $(1)/etc
	$(INSTALL_DIR) $(1)/etc/acdbdata/MTP
	$(INSTALL_BIN) $(PKG_BUILD_DIR)/.libs/libqal.so $(1)/usr/lib
	$(INSTALL_BIN) ./files/ipq6018/*.xml $(1)/etc
	$(INSTALL_BIN) ./files/ipq6018/acdb_cal.acdb $(1)/etc/acdbdata/MTP
endef

$(eval $(call BuildPackage,qal))
