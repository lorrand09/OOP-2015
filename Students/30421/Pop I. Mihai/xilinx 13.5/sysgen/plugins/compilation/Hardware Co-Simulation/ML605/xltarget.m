%
% Filename:    xltarget.m
%
% Description: Defines the target compilation entry points

function s = xltarget
  s = {
     struct('name', 'ML605 (JTAG)', ...
            'target_info', 'xlHwcosimTarget(''ml605-jtag'')', ...
            'title', 'JTAG'), ...
     struct('name', 'ML605 (Point-to-point Ethernet)', ...
            'target_info', 'xlHwcosimTarget(''ml605-ppethernet'')', ...
            'title', 'Point-to-point Ethernet'), ...
  };