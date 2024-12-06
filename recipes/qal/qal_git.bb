inherit autotools pkgconfig systemd

DESCRIPTION = "qal"
SECTION = "multimedia"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM += "file://Pal.cpp;beginline=31;endline=32;md5=e733afaf233fbcbc22769d0a9bda0b3e \
                     file://inc/PalDefs.h;beginline=30;endline=31;md5=e733afaf233fbcbc22769d0a9bda0b3e"

FILESPATH =+ "${WORKSPACE}/:"
SRC_URI  = "file://vendor/qcom/opensource/pal/ \
            file://0001-pal-pal-patch.patch \
            file://adsprpcd_audiopd.service"

S = "${WORKDIR}/vendor/qcom/opensource/pal"

DEPENDS = "tinyalsa tinycompress agm mm-audio-headers audio-route dspservices-headers vui-interface qal-headers media-headers"

EXTRA_OECONF += "--with-glib --without-syslog"
EXTRA_OECONF += "--with-basemachine=${BASEMACHINE}"
EXTRA_OECONF:append:pineapple = "--with-spkrcalpath=/data/misc/audio/audio.cal"

SYSTEMD_SERVICE:${PN} += "adsprpcd_audiopd.service"

do_install:append () {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/adsprpcd_audiopd.service ${D}${systemd_system_unitdir}
    install -d ${D}${systemd_system_unitdir}/multi-user.target.wants/
    ln -sf ${systemd_system_unitdir}/adsprpcd_audiopd.service \
           ${D}${systemd_system_unitdir}/multi-user.target.wants/adsprpcd_audiopd.service
}

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

FILES:${PN} += "${libdir}/*.so ${libdir}/pkgconfig/ ${systemd_unitdir}/system/* ${sysconfdir}/* ${bindir}/*"
FILES:${PN}-dev = "${libdir}/*.la ${includedir}"
