inherit autotools pkgconfig

DESCRIPTION = "pal"
SECTION = "multimedia"
LICENSE = "BSD-Source-Code"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/\
${LICENSE};md5=fe8b41221d7524c70688f7d059ff6d87"

FILESPATH =+ "${WORKSPACE}/:"
SRC_URI  = "file://vendor/qcom/opensource/pal/"

S = "${WORKDIR}/vendor/qcom/opensource/pal/"
PR = "r0"
DEPENDS = "tinyalsa tinycompress agm-client audio-route mm-audio-headers media-headers"

do_install:append:kalama() {
	mkdir -p -m 0755 ${D}${sysconfdir}
	install -m 0644 ${S}configs/kalama-le/card-defs.xml ${D}${sysconfdir}/card-defs.xml
	install -m 0644 ${S}configs/kalama-le/mixer_paths_kalama_qrd.xml ${D}${sysconfdir}/mixer_paths_kalama_qrd.xml
	install -m 0644 ${S}configs/kalama-le/resourcemanager_kalama_qrd.xml ${D}${sysconfdir}/resourcemanager_kalama_qrd.xml
	install -m 0644 ${S}configs/kalama-le/mixer_paths_kalama_rb5_gen2.xml ${D}${sysconfdir}/mixer_paths_kalama_rb5_gen2.xml
	install -m 0644 ${S}configs/kalama-le/resourcemanager_kalama_rb5_gen2.xml ${D}${sysconfdir}/resourcemanager_kalama_rb5_gen2.xml
	install -m 0644 ${S}configs/kalama-le/mixer_paths_kalama_rb5_gen2_dvt.xml ${D}${sysconfdir}/mixer_paths_kalama_rb5_gen2_dvt.xml
	install -m 0644 ${S}configs/kalama-le/resourcemanager_kalama_rb5_gen2_dvt.xml ${D}${sysconfdir}/resourcemanager_kalama_rb5_gen2_dvt.xml
	install -m 0644 ${S}configs/kalama-le/mixer_paths_kalama_cdp.xml ${D}${sysconfdir}/mixer_paths_kalama_cdp.xml
	install -m 0644 ${S}configs/kalama-le/mixer_paths_kalama_cdp_wsa883x.xml ${D}${sysconfdir}/mixer_paths_kalama_cdp_wsa883x.xml
	install -m 0644 ${S}configs/kalama-le/resourcemanager_kalama_cdp.xml ${D}${sysconfdir}/resourcemanager_kalama_cdp.xml
	install -m 0644 ${S}configs/kalama-le/usecaseKvManager.xml ${D}${sysconfdir}/usecaseKvManager.xml
}

EXTRA_OECONF += "--with-glib"
EXTRA_OECONF += "--with-basemachine=${BASEMACHINE}"

SOLIBS = ".so"

FILES_SOLIBSDEV = ""
