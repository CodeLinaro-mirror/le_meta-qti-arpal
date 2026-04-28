inherit autotools pkgconfig systemd

DESCRIPTION = "pal"
SECTION = "multimedia"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/\
${LICENSE};md5=550794465ba0ec5312d6919e203a55f9"

FILESPATH =+ "${WORKSPACE}/:"
SRC_URI  = "file://vendor/qcom/opensource/pal/ \
            file://adsprpcd_audiopd.service"

S = "${WORKDIR}/vendor/qcom/opensource/pal/"
PR = "r0"
DEPENDS = "tinyalsa audio-route mm-audio-headers dspservices-headers tinycompress agm media-headers"

EXTRA_OECONF += "--with-glib"
EXTRA_OECONF += "--with-acdbdata=${STAGING_INCDIR}/acdbdata"

do_install:append:qrbx210-rbx() {
    mkdir -p -m 0755 ${D}${sysconfdir}
    install -m 0644 ${S}/configs/bengal/mixer_paths_bengal_rb2_v4.xml ${D}${sysconfdir}/mixer_paths_bengal_rb2_v4.xml
    install -m 0644 ${S}/configs/bengal/resourcemanager_bengal_rb2_v4.xml ${D}${sysconfdir}/resourcemanager_bengal_rb2_v4.xml
    install -m 0644 ${S}/configs/bengal/usecaseKvManager.xml ${D}${sysconfdir}/usecaseKvManager.xml
    install -d ${D}${systemd_unitdir}/system
    install -m 0755 ${WORKDIR}/adsprpcd_audiopd.service ${D}${systemd_unitdir}/system/
}

SYSTEMD_SERVICE:${PN}:append = " adsprpcd_audiopd.service"

FILES:${PN} += "${libdir}/*.so ${libdir}/pkgconfig/ ${systemd_unitdir}/system/* ${sysconfdir}/* ${bindir}/*"
FILES:${PN}-dev = "${libdir}/*.la ${includedir} ${libdir}/pkgconfig$/codecs.pc"

SOLIBS = ".so"

FILES_SOLIBSDEV = ""
