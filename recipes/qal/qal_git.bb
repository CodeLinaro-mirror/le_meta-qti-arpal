inherit autotools pkgconfig systemd

DESCRIPTION = "qal"
SECTION = "multimedia"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/${LICENSE};md5=550794465ba0ec5312d6919e203a55f9"

FILESPATH =+ "${WORKSPACE}/:"
SRC_URI  = "file://vendor/qcom/opensource/pal/ \
            file://adsprpcd_audiopd.service \
            file://0001-pal-pal-patch.patch"

S = "${WORKDIR}/vendor/qcom/opensource/pal"

DEPENDS = "tinyalsa tinycompress agm mm-audio-headers audio-route dspservices-headers qal-headers media-headers binder audio-memlogger"

EXTRA_OECONF += "--with-glib --without-syslog --with-spf"
EXTRA_OECONF += "--with-basemachine=${BASEMACHINE}"
EXTRA_OECONF:append = " ${@bb.utils.contains_any('BASEMACHINE', 'pineapple sun kera sdmsteppe', '--with-spkrcalpath=/data/misc/audio/audio.cal', '', d)}"

do_install:append:pineapple() {
    mkdir -p -m 0755 ${D}${sysconfdir}
    install -m 0644 ${S}/configs/pineapple-le/card-defs.xml ${D}${sysconfdir}/card-defs.xml
    install -m 0644 ${S}/configs/pineapple-le/mixer_paths_cliffs_qrd.xml ${D}${sysconfdir}/mixer_paths_cliffs_qrd.xml
    install -m 0644 ${S}/configs/pineapple-le/mixer_paths_pineapple_qrd_sku2.xml ${D}${sysconfdir}/mixer_paths_pineapple_qrd_sku2.xml
    install -m 0644 ${S}/configs/pineapple-le/resourcemanager_cliffs_qrd.xml ${D}${sysconfdir}/resourcemanager_cliffs_qrd.xml
    install -m 0644 ${S}/configs/pineapple-le/resourcemanager_pineapple_qrd.xml ${D}${sysconfdir}/resourcemanager_pineapple_qrd.xml
    install -m 0644 ${S}/configs/pineapple-le/Hapticsconfig.xml ${D}${sysconfdir}/Hapticsconfig.xml
    install -m 0644 ${S}/configs/pineapple-le/mixer_paths_pineapple_aim.xml ${D}${sysconfdir}/mixer_paths_pineapple_aim.xml
    install -m 0644 ${S}/configs/pineapple-le/mixer_paths_pineapple_qrd.xml ${D}${sysconfdir}/mixer_paths_pineapple_qrd.xml
    install -m 0644 ${S}/configs/pineapple-le/resourcemanager_pineapple_aim.xml ${D}${sysconfdir}/resourcemanager_pineapple_aim.xml
    install -m 0644 ${S}/configs/pineapple-le/usecaseKvManager.xml ${D}${sysconfdir}/usecaseKvManager.xml
    install -m 0644 ${S}/configs/pineapple-le/mixer_paths_cliffs_cdp.xml ${D}${sysconfdir}/mixer_paths_cliffs_cdp.xml
    install -m 0644 ${S}/configs/pineapple-le/mixer_paths_pineapple_cdp_wsa883x.xml ${D}${sysconfdir}/mixer_paths_pineapple_cdp_wsa883x.xml
    install -m 0644 ${S}/configs/pineapple-le/resourcemanager_cliffs_cdp.xml ${D}${sysconfdir}/resourcemanager_cliffs_cdp.xml
    install -m 0644 ${S}/configs/pineapple-le/resourcemanager_pineapple_cdp.xml ${D}${sysconfdir}/resourcemanager_pineapple_cdp.xml
    install -m 0644 ${S}/configs/pineapple-le/mixer_paths_cliffs_mtp_wcd9395.xml ${D}${sysconfdir}/mixer_paths_cliffs_mtp_wcd9395.xml
    install -m 0644 ${S}/configs/pineapple-le/mixer_paths_pineapple_cdp.xml ${D}${sysconfdir}/mixer_paths_pineapple_cdp.xml
    install -m 0644 ${S}/configs/pineapple-le/resourcemanager_cliffs_mtp_wcd9395.xml ${D}${sysconfdir}/resourcemanager_cliffs_mtp_wcd9395.xml
    install -m 0644 ${S}/configs/pineapple-le/resourcemanager_pineapple_mtp.xml ${D}${sysconfdir}/resourcemanager_pineapple_mtp.xml
    install -m 0644 ${S}/configs/pineapple-le/mixer_paths_cliffs_mtp.xml ${D}${sysconfdir}/mixer_paths_cliffs_mtp.xml
    install -m 0644 ${S}/configs/pineapple-le/mixer_paths_pineapple_mtp.xml ${D}${sysconfdir}/mixer_paths_pineapple_mtp.xml
    install -m 0644 ${S}/configs/pineapple-le/resourcemanager_cliffs_mtp.xml ${D}${sysconfdir}/resourcemanager_cliffs_mtp.xml
    install -m 0644 ${S}/configs/pineapple-le/resourcemanager_pineapple_qrd_sku2.xml ${D}${sysconfdir}/resourcemanager_pineapple_qrd_sku2.xml
}

do_install:append:sun() {
    mkdir -p -m 0755 ${D}${sysconfdir}
    install -m 0644 ${S}/configs/sun/card-defs.xml ${D}${sysconfdir}/card-defs.xml
    install -m 0644 ${S}/configs/sun/mixer_paths_sun_qrd_sku2.xml ${D}${sysconfdir}/mixer_paths_sun_qrd_sku2.xml
    install -m 0644 ${S}/configs/sun/resourcemanager_sun_qrd.xml ${D}${sysconfdir}/resourcemanager_sun_qrd.xml
    install -m 0644 ${S}/configs/sun/Hapticsconfig.xml ${D}${sysconfdir}/Hapticsconfig.xml
    install -m 0644 ${S}/configs/sun/mixer_paths_sun_qrd.xml ${D}${sysconfdir}/mixer_paths_sun_qrd.xml
    install -m 0644 ${S}/configs/sun/usecaseKvManager.xml ${D}${sysconfdir}/usecaseKvManager.xml
    install -m 0644 ${S}/configs/sun/mixer_paths_sun_mtp_wsa883x_qmp.xml ${D}${sysconfdir}/mixer_paths_sun_mtp_wsa883x_qmp.xml
    install -m 0644 ${S}/configs/sun/resourcemanager_sun_cdp.xml ${D}${sysconfdir}/resourcemanager_sun_cdp.xml
    install -m 0644 ${S}/configs/sun/mixer_paths_sun_cdp.xml ${D}${sysconfdir}/mixer_paths_sun_cdp.xml
    install -m 0644 ${S}/configs/sun/resourcemanager_sun_mtp.xml ${D}${sysconfdir}/resourcemanager_sun_mtp.xml
    install -m 0644 ${S}/configs/sun/mixer_paths_sun_mtp.xml ${D}${sysconfdir}/mixer_paths_sun_mtp.xml
    install -m 0644 ${S}/configs/sun/resourcemanager_sun_qrd_sku2.xml ${D}${sysconfdir}/resourcemanager_sun_qrd_sku2.xml
    install -m 0644 ${S}/configs/sun/plugin_manager.xml ${D}${sysconfdir}/plugin_manager.xml
    install -d ${D}${systemd_unitdir}/system
    install -m 0755 ${WORKDIR}/adsprpcd_audiopd.service ${D}${systemd_unitdir}/system/
}

do_install:append:kera() {
    mkdir -p -m 0755 ${D}${sysconfdir}
    install -m 0644 ${S}/configs/kera-le/card-defs.xml ${D}${sysconfdir}/card-defs.xml
    install -m 0644 ${S}/configs/kera-le/resourcemanager_kera_qrd.xml ${D}${sysconfdir}/resourcemanager_kera_qrd.xml
    install -m 0644 ${S}/configs/kera-le/Hapticsconfig.xml ${D}${sysconfdir}/Hapticsconfig.xml
    install -m 0644 ${S}/configs/kera-le/mixer_paths_kera_qrd.xml ${D}${sysconfdir}/mixer_paths_kera_qrd.xml
    install -m 0644 ${S}/configs/kera-le/usecaseKvManager.xml ${D}${sysconfdir}/usecaseKvManager.xml
    install -m 0644 ${S}/configs/kera-le/resourcemanager_kera_cdp.xml ${D}${sysconfdir}/resourcemanager_kera_cdp.xml
    install -m 0644 ${S}/configs/kera-le/mixer_paths_kera_cdp.xml ${D}${sysconfdir}/mixer_paths_kera_cdp.xml
    install -m 0644 ${S}/configs/kera-le/resourcemanager_kera_mtp.xml ${D}${sysconfdir}/resourcemanager_kera_mtp.xml
    install -m 0644 ${S}/configs/kera-le/mixer_paths_kera_mtp.xml ${D}${sysconfdir}/mixer_paths_kera_mtp.xml
    install -m 0644 ${S}/configs/kera-le/plugin_manager.xml ${D}${sysconfdir}/plugin_manager.xml
    install -d ${D}${systemd_unitdir}/system
    install -m 0755 ${WORKDIR}/adsprpcd_audiopd.service ${D}${systemd_unitdir}/system/
}

do_install:append:sdmsteppe() {
   mkdir -p -m 0755 ${D}${sysconfdir}
   install -m 0644 ${S}/configs/sdmsteppe/audio_effects.xml ${D}${sysconfdir}/audio_effects.xml
   install -m 0644 ${S}/configs/sdmsteppe/audio_platform_info_intcodec.xml ${D}${sysconfdir}/audio_platform_info_intcodec.xml
   install -m 0644 ${S}/configs/sdmsteppe/audio_platform_info_qrd.xml ${D}${sysconfdir}/audio_platform_info_qrd.xml
   install -m 0644 ${S}/configs/sdmsteppe/audio_platform_info.xml ${D}${sysconfdir}/audio_platform_info.xml
   install -m 0644 ${S}/configs/sdmsteppe/audio_policy_configuration_odm.xml ${D}${sysconfdir}/audio_policy_configuration_odm.xml
   install -m 0644 ${S}/configs/sdmsteppe/audio_policy_configuration.xml ${D}${sysconfdir}/audio_policy_configuration.xml
   install -m 0644 ${S}/configs/sdmsteppe/graphite_ipc_platform_info.xml ${D}${sysconfdir}/graphite_ipc_platform_info.xml
   install -m 0644 ${S}/configs/sdmsteppe/listen_platform_info.xml ${D}${sysconfdir}/listen_platform_info.xml
   install -m 0644 ${S}/configs/sdmsteppe/mixer_paths_sm6150_idp.xml ${D}${sysconfdir}/mixer_paths_sm6150_idp.xml
   install -m 0644 ${S}/configs/sdmsteppe/mixer_paths_ipc.xml ${D}${sysconfdir}/mixer_paths_ipc.xml
   install -m 0644 ${S}/configs/sdmsteppe/mixer_paths_qrd.xml ${D}${sysconfdir}/mixer_paths_qrd.xml
   install -m 0644 ${S}/configs/sdmsteppe/mixer_paths_tavil.xml ${D}${sysconfdir}/mixer_paths_tavil.xml
   install -m 0644 ${S}/configs/sdmsteppe/mixer_paths_wcd9375qrd.xml ${D}${sysconfdir}/mixer_paths_wcd9375qrd.xml
   install -m 0644 ${S}/configs/sdmsteppe/mixer_paths_wcd9375.xml ${D}${sysconfdir}/mixer_paths_wcd9375.xml
   install -m 0644 ${S}/configs/sdmsteppe/sound_trigger_mixer_paths_qrd.xml ${D}${sysconfdir}/sound_trigger_mixer_paths_qrd.xml
   install -m 0644 ${S}/configs/sdmsteppe/sound_trigger_mixer_paths_wcd9340.xml ${D}${sysconfdir}/sound_trigger_mixer_paths_wcd9340.xml
   install -m 0644 ${S}/configs/sdmsteppe/sound_trigger_mixer_paths.xml ${D}${sysconfdir}/sound_trigger_mixer_paths.xml
   install -m 0644 ${S}/configs/sdmsteppe/sound_trigger_platform_info.xml ${D}${sysconfdir}/sound_trigger_platform_info.xml
   install -m 0644 ${S}/configs/sdmsteppe/resourcemanager_sm6150_idp.xml ${D}${sysconfdir}/resourcemanager_sm6150_idp.xml
   install -m 0644 ${S}/configs/sdmsteppe/usecaseKvManager.xml ${D}${sysconfdir}/usecaseKvManager.xml
   install -m 0644 ${S}/configs/sdmsteppe/plugin_manager.xml ${D}${sysconfdir}/plugin_manager.xml
   install -d ${D}${systemd_unitdir}/system
   install -m 0755 ${WORKDIR}/adsprpcd_audiopd.service ${D}${systemd_unitdir}/system/
}

SYSTEMD_SERVICE:${PN}:append = " adsprpcd_audiopd.service"

FILES:${PN} += "${libdir}/*.so ${libdir}/pkgconfig/ ${systemd_unitdir}/system/* ${sysconfdir}/* ${bindir}/*"
FILES:${PN}-dev = "${libdir}/*.la ${includedir} ${libdir}/pkgconfig$/codecs.pc"
